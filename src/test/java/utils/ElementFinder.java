package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;

public class ElementFinder {

    private static final Logger log = LogManager.getLogger(ElementFinder.class);
    WebDriver driver;

    public ElementFinder(WebDriver driver) {
        this.driver = driver;
    }

    public void safeClickIfPresent(By locator, String elementName) {
        log.info("Checking presence of optional element: {} | Locator: {}",elementName,locator);

        try {
            Thread.sleep(2000);
            List<WebElement> elements = driver.findElements(locator);

            if(!elements.isEmpty()){
                log.info("Element found proceeding to click: {}",elementName);
                safeClick(locator,elementName);
            }
            else{
                log.info("Element not present (skipping): {}",elementName);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void safeClick(By locator, String elementName) {
        WaitUtils customWait = new WaitUtils(driver);
        int attempts = 3;

        log.info("👉 Attempting to click: {} | Locator: {}", elementName, locator);

        while (attempts > 0) {
            try {
                WebElement element = customWait.isClickable(locator);

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

                element.click();

                log.info("✅ Click successful: {}", elementName);
                return;

            } catch (StaleElementReferenceException e) {
                attempts--;
                log.warn("🔁 Stale element [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (ElementClickInterceptedException e) {
                attempts--;
                log.warn("⚠️ Click intercepted [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (ElementNotInteractableException e) {
                attempts--;
                log.warn("🚫 Element not interactable [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (NoSuchElementException e) {
                attempts--;
                log.warn("🔍 Element not found [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (TimeoutException e) {
                attempts--;
                log.warn("⏳ Timeout for [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (WebDriverException e) {
                attempts--;
                log.error("⚠️ WebDriver issue while clicking [{}]: {}", elementName, e.getMessage());
            }
        }

        log.error("❌ Failed to click after retries: {} | Locator: {}", elementName, locator);
        throw new RuntimeException("Failed to click: " + elementName);
    }

    public void safeSendKeys(By locator, String text, String elementName) {
        WaitUtils customWait = new WaitUtils(driver);
        int attempts = 3;

        log.info("👉 Attempting to enter text in: {} | Locator: {}", elementName, locator);

        while (attempts > 0) {
            try {
                WebElement element = customWait.isVisible(locator);

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

                element.clear();
                element.sendKeys(text);

                log.info("✅ Text entered successfully in: {} → [{}]", elementName, text);
                return;

            } catch (StaleElementReferenceException e) {
                attempts--;
                log.warn("🔁 Stale element [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (ElementNotInteractableException e) {
                attempts--;
                log.warn("🚫 Element not interactable [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (InvalidElementStateException e) {
                attempts--;
                log.warn("⚠️ Invalid state [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (NoSuchElementException e) {
                attempts--;
                log.warn("🔍 Element not found [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (TimeoutException e) {
                attempts--;
                log.warn("⏳ Timeout for [{}], retrying... Remaining: {}", elementName, attempts);

            } catch (WebDriverException e) {
                attempts--;
                log.error("⚠️ WebDriver issue while sending keys to [{}]: {}", elementName, e.getMessage());
            }
        }

        log.error("❌ Failed to send keys after retries: {} | Locator: {} | Text: {}", elementName, locator, text);
        throw new RuntimeException("Failed to send keys: " + elementName);
    }
}