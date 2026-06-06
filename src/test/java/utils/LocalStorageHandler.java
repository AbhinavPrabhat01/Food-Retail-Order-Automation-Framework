package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LocalStorageHandler {

    private static final Logger log = LogManager.getLogger(LocalStorageHandler.class);

    public static void setLocation(WebDriver driver){
        try{
            log.info("📍 Injecting location into localStorage...");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            String json = Files.readString(Paths.get("src/test/java/resources/location.json"));
            log.debug("📄 Location JSON loaded successfully");

            js.executeScript(
                    "window.localStorage.setItem('store-location-store', arguments[0]);",
                    json
            );

            driver.navigate().refresh();

            log.info("✅ Location injected into localStorage and page refreshed");

        } catch (IOException e) {
            log.error("❌ Location injection failed", e);
        }
    }
}