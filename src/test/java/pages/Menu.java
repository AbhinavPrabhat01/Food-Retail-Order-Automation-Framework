package pages;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class Menu extends BasePage {

    private static final Logger log = LogManager.getLogger(Menu.class);

    public Menu(WebDriver driver){
        super(driver);
    }

    public void openMenu(){
        log.info("🌐 Opening menu page...");
        driver.get("https://qa.papajohns.com/order/menu/pizza");
        log.info("✅ Menu page opened successfully");
    }

    public void selectCategory(String category){
        String customXpath = "//a[@data-id='"+category+"']";

        log.info("📂 Selecting category: {}", category);
        finder.safeClick(By.xpath(customXpath), category + " Category");
    }

    public void selectProduct(String product){
        String customXpath = "//h4[contains(text(),'"+product+"')]";

        log.info("🍕 Selecting product: {}", product);
        finder.safeClick(By.xpath(customXpath), product + " Product");
    }

    public void selectQuantity(int quantity){
        WaitUtils customWait = new WaitUtils(driver);

        if (quantity == 1){
            log.info("🔢 Quantity is 1 → No selection needed (default)");
            return;
        }

        try{
            log.info("🔢 Selecting quantity: {}", quantity);

            WebElement quantityDropdown = customWait.isClickable(By.xpath("//*[@id=\"quantity\"]"));
            Select select = new Select(quantityDropdown);
            select.selectByVisibleText(String.valueOf(quantity));

            log.info("✅ Quantity selected successfully: {}", quantity);

        } catch (TimeoutException e) {
            log.error("❌ Quantity dropdown not found", e);
        }
    }

    public void addToOrder(){
        log.info("➕ Adding item to cart");
        finder.safeClick(By.xpath("//button[@data-id=\"add-to-cart\"]"), "Add To Order");
    }

    public void openCart(){
        log.info("🛒 Opening cart page");
        finder.safeClick(By.xpath("//a[@href=\"/order/cart\"]"), "Open Cart");
    }
}