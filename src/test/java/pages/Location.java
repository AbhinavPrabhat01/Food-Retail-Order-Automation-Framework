package pages;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.LocalStorageHandler;

public class Location extends BasePage {

    private static final Logger log = LogManager.getLogger(Location.class);

    public Location(WebDriver driver){
        super(driver);
    }

    public void setLocation() {
        try{
            log.info("📍 Setting location using local storage...");
            LocalStorageHandler.setLocation(driver);

            log.debug("⏳ Waiting for page to stabilize after location set");
            Thread.sleep(4000);

            log.info("✅ Location set successfully");

        } catch (InterruptedException e) {
            log.error("⚠️ Thread.sleep interrupted in Location.setLocation()", e);
        }
    }
}