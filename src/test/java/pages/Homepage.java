package pages;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class Homepage extends BasePage {

    private static final Logger log = LogManager.getLogger(Homepage.class);


    public Homepage(WebDriver driver){
        super(driver);
    }

    public void openWebsite(String url){
        log.info("🌐 Opening website: {}", url);
        driver.get(url);
        log.info("✅ Website opened successfully");

        log.info("Checking for cookies popup");
        finder.safeClickIfPresent(By.id("onetrust-accept-btn-handler"),"Cookie accept button");

        log.info("Checking for Papa Dough Blocker");
        finder.safeClickIfPresent(By.xpath("//button[@id='ixh98']"),"Papa Dough Blocker");
    }

    public void clearCart(){
        WaitUtils customWait = new WaitUtils(driver);
        WebElement cartButton = customWait.isClickable(By.xpath("//a[@href = '/order/cart']"));
        String cartItem = cartButton.getText();
        if (cartItem.charAt(0) == '$'){
            System.out.println("Cart already empty");
        }
        else{
            finder.safeClick(By.xpath("//a[@href = '/order/cart']"),"Cart button");
            finder.safeClick(By.xpath("//a[text()='Remove all items']"),"Remove button");
            finder.safeClick(By.xpath("//button[text()='OK']"),"OK");
        }
    }
}