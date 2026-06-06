package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static final Logger log = LogManager.getLogger(DriverFactory.class);

    public static WebDriver initDriver(){
        log.info("🚀 Initializing Chrome WebDriver...");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--start-maximized");

        log.debug("⚙️ Applied Chrome options for automation");

        //Custom Profile
        options.addArguments("--user-data-dir=C:/My_Files/Programming/AutomationUtils/ChromeProfiles");
        options.addArguments(
                "--profile-directory=Default"
        );
        log.debug("📁 Using custom Chrome profile: Automation QA");

        WebDriver driver = new ChromeDriver(options);

        log.info("✅ Chrome WebDriver initialized successfully");

        return driver;
    }
}