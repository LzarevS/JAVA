package src;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import static src.SiteMap.CrawlTask.clearFile;

public class SiteMap {
    private static final String OUTPUT_FILE = "site_map.txt";
    private static final String STARTING_URL = "https://sendel.ru/";
    private static final int MAX_DEPTH = 3;
    private static final int CONNECTION_TIMEOUT = 10000; // Установка таймаута соединения (10 секунд)
    private static final int PAUSE_MIN = 1000; // Минимальная задержка между запросами в миллисекундах
    private static final int PAUSE_MAX = 1500; // Максимальная задержка между запросами в миллисекундах

    private static final Set<String> visitedUrls = new HashSet<>();
    private static final Logger logger = Logger.getLogger(SiteMap.class.getName());
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        clearFile();

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new CrawlTask(STARTING_URL, 0));

        pool.shutdown();

        System.out.println("Site map generated successfully!");
    }

    static class CrawlTask extends RecursiveAction {
        private final String url;
        private final int depth;

        public CrawlTask(String url, int depth) {
            this.url = url;
            this.depth = depth;
        }

        @Override
        protected void compute() {
            if (depth > MAX_DEPTH || visitedUrls.contains(url)) {
                return;
            }

            visitedUrls.add(url);

            try {
                Connection connection = Jsoup.connect(url);
                connection.timeout(CONNECTION_TIMEOUT); // Устанавливаем таймаут для соединения
                Document document = connection.get();
                Elements links = document.select("a[href]");

                writeLinkToFile(url, depth);

                List<CrawlTask> tasks = new ArrayList<>();

                for (Element link : links) {
                    String childUrl = link.absUrl("href");
                    if (isValidUrl(childUrl) && !visitedUrls.contains(childUrl)) {
                        CrawlTask task = new CrawlTask(childUrl, depth + 1);
                        tasks.add(task);
                        task.fork();
                    }
                }

                for (CrawlTask task : tasks) {
                    task.join();
                }
            } catch (IOException e) {
                logger.log(Level.WARNING, "An error occurred while crawling the site: " + e.getMessage(), e);
            }

            // Добавляем паузу между запросами страниц
            try {
                Thread.sleep(getRandomPause());
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Thread interrupted while pausing: " + e.getMessage(), e);
                Thread.currentThread().interrupt(); // Сохраняем флаг прерывания
            }
        }


        private static void writeLinkToFile(String url, int depth) {
            lock.lock();
            try (FileWriter writer = new FileWriter(OUTPUT_FILE, true)) {
                StringBuilder indentation = new StringBuilder();
                for (int i = 0; i < depth; i++) {
                    indentation.append("    ");
                }
                writer.write(indentation.toString() + url + "\n");
            } catch (IOException e) {
                logger.log(Level.SEVERE, "An error occurred while writing to the file: " + e.getMessage(), e);
            } finally {
                lock.unlock();
            }
        }

        private static boolean isValidUrl(String url) {
            return url.startsWith(STARTING_URL) && !url.contains("#");
        }

        static void clearFile() {
            lock.lock();
            try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
                // Clear the file by opening and closing it
            } catch (IOException e) {
                logger.log(Level.SEVERE, "An error occurred while clearing the file: " + e.getMessage(), e);
            } finally {
                lock.unlock();
            }
        }

        private static int getRandomPause() {
            return (int) (PAUSE_MIN + Math.random() * (PAUSE_MAX - PAUSE_MIN + 1));
        }
    }
}