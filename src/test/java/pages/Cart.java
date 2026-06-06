package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends BasePage {
    public Cart(WebDriver driver) {
        super(driver);
    }

    public void checkout(){
        finder.safeClick(By.xpath("//button[.//span[text()='Check out']]"),"Checkout");
    }
}
