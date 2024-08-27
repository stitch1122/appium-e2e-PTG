package android.pages;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

public class CacheAndOthersPage extends BasePage {
    public CacheAndOthersPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void executeAdbRoot() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("adb", "root");
            Process process = processBuilder.start();
            process.waitFor();

            // Чтение вывода команды
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // Проверка кода завершения
            if (process.exitValue() != 0) {
                throw new RuntimeException("Не удалось выполнить adb root");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ошибка при выполнении adb root", e);
        }
    }

    public void checkAdbRoot() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("adb", "get-state");
            Process process = processBuilder.start();
            process.waitFor();
            // Чтение вывода команды
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String state = reader.readLine();

            if (!"device".equals(state)) {
                throw new RuntimeException("Устройство не доступно.");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ошибка при проверке состояния ADB", e);
        }
    }
    public void checkCacheInFolderHasFiles() throws InterruptedException {
        byte[] folder = driver.pullFolder("/storage/emulated/0/Android/data/" + Constants.APP_PACKAGE + "/");
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(folder);
             ZipInputStream gzipInputStream = new ZipInputStream(byteArrayInputStream)) {

            List<ZipEntry> zipEntries = new ArrayList<>();
            ZipEntry nextEntry;
            while ((nextEntry = gzipInputStream.getNextEntry()) != null) {
                if (!nextEntry.isDirectory()) {
                    zipEntries.add(nextEntry);
                }
            }
            boolean hasFiles = !zipEntries.isEmpty();
            Assert.assertTrue(hasFiles, "Ожидалось, что кэш будет содержать файлы, но он пуст");
            if (hasFiles) {
                System.out.println("Кэш содержит файлы.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось распаковать содержимое", e);
        }
    }

    public void checkCacheInFolderNotHasFiles() throws InterruptedException {
        byte[] folder = driver.pullFolder("/storage/emulated/0/Android/data/" + Constants.APP_PACKAGE + "/");
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(folder);
             ZipInputStream gzipInputStream = new ZipInputStream(byteArrayInputStream)) {

            List<ZipEntry> zipEntries = new ArrayList<>();
            ZipEntry nextEntry;
            while ((nextEntry = gzipInputStream.getNextEntry()) != null) {
                if (!nextEntry.isDirectory()) {
                    zipEntries.add(nextEntry);
                }
            }
            boolean hasFiles = !zipEntries.isEmpty();
            Assert.assertFalse(hasFiles, "Кэш содержит файлы.");

            if (!hasFiles) {
                System.out.println("Кэш не содержит файлов.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось распаковать содержимое", e);
        }
    }

    public static void takeScreenshot(String filename) {
        try {
            // Сделать скриншот на устройстве
            Process process = Runtime.getRuntime().exec(new String[]{
                    "adb", "shell", "screencap", "-p", "/sdcard/" + filename
            });
            process.waitFor();

            if (process.exitValue() != 0) {
                throw new IOException("Failed to take screenshot");
            }

            process = Runtime.getRuntime().exec(new String[]{
                    "adb", "pull", "/sdcard/" + filename, "."
            });
            process.waitFor();

            if (process.exitValue() != 0) {
                throw new IOException("Failed to pull screenshot from device");
            }

            System.out.println("Screenshot saved as: " + filename);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean compareImages(String imagePath1, String imagePath2) throws IOException {
        BufferedImage img1 = ImageIO.read(new File(imagePath1));
        BufferedImage img2 = ImageIO.read(new File(imagePath2));

        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return true; // Разные размеры изображений
        }

        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return true; // Изображения отличаются
                }
            }
        }
        return false; // Изображения идентичны
    }

    public static void deleteFile(String filename) {
        String[] command = new String[]{"adb", "shell", "rm", "/sdcard/" + filename};

        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            if (process.exitValue() == 0) {
                System.out.println("Deleted: " + filename);
            } else {
                System.out.println("Failed to delete: " + filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.err.println(line);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    public void compareScreen(String screen1, String screen2) {
        try {
            boolean areDifferent = compareImages(screen1, screen2);
            System.out.println("Screenshots are different: " + areDifferent);
            deleteFile(screen1);
            deleteFile(screen2);
            Assert.assertTrue(areDifferent, "Screenshots should not be the same");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void blockAndUnlockScreen() throws Exception {
        // Блокировка экрана
        Runtime.getRuntime().exec("adb shell input keyevent 26");
        Thread.sleep(2000);
        System.out.println("Экран заблокирован");

        // Разблокировка экрана
        Runtime.getRuntime().exec("adb shell input keyevent 82");
        Thread.sleep(2000);
        System.out.println("Экран разблокирован");
    }
    public void homeScreen() throws Exception {
        // Блокировка экрана
        Runtime.getRuntime().exec("adb shell input keyevent 3");
        Thread.sleep(2000);
        System.out.println("Домой");
    }

}
