import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 class Main {

    public static void main(String[] args) {

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + processors);


        ExecutorService executor = Executors.newFixedThreadPool(processors);

        String srcFolder = "C:\\Users\\User\\Desktop\\src";
        String dstFolder = "C:\\Users\\User\\Desktop\\dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        try {
            for (File file : files) {
                if (!isImage(file)) {
                    System.out.println(file.getName() + " is not an image. Skipping...");
                    continue;
                }


                executor.submit(new ResizeTask(file, dstFolder));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        executor.shutdown();


        while (!executor.isTerminated()) {}

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }

    private static boolean isImage(File file) {
        try {
            ImageIO.read(file);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    static class ResizeTask implements Runnable {
        private final File file;
        private final String dstFolder;

        public ResizeTask(File file, String dstFolder) {
            this.file = file;
            this.dstFolder = dstFolder;
        }

        @Override
        public void run() {
            try {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    return;
                }

                int newWidth = 300;
                int newHeight = 300;

                BufferedImage newImage = Scalr.resize(image, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH, newWidth, newHeight);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
