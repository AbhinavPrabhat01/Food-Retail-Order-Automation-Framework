package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    private static final Logger log = LogManager.getLogger(ScreenshotUtils.class);

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            String screenshotDir = System.getProperty("user.dir") + "/reports/";
            String filePath = screenshotDir + testName + "_" + timestamp + ".png";

            Files.createDirectories(Paths.get(screenshotDir));

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            Files.copy(source.toPath(), Paths.get(filePath));

            log.info("📸 Screenshot captured: {}", filePath);

            return filePath;

        } catch (IOException e) {
            log.error("❌ Failed to capture screenshot", e);
            return null;
        }
    }
}