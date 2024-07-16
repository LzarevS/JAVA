package src;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SiteMap {
    private static final int MAX_DEPTH = 2;
    private static final String OUTPUT_FILE = "site_map.txt";

    private static Set<String> visitedUrls = new HashSet<>();

    public static void main(String[] args) {
        String startingUrl = "https://sendel.ru/"; // Замените на ваш URL
        crawlSite(startingUrl, 0);
    }

    private static void crawlSite(String url, int depth) {
        if (depth > MAX_DEPTH || visitedUrls.contains(url)) {
            return;
        }

        visitedUrls.add(url);

        try {
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");

            writeLinksToFile(links, depth);

            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (Element link : links) {
                String childUrl = link.absUrl("href");
                executor.submit(() -> crawlSite(childUrl, depth + 1));
            }
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS); // Ждем завершения всех потоков не более 30 секунд
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void writeLinksToFile(Elements links, int depth) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE, true)) {
            for (Element link : links) {
                writer.write("\t".repeat(depth)); // Отступы на одну табуляцию
                writer.write(link.absUrl("href") + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
