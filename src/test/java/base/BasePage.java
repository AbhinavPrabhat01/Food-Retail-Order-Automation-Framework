package base;

import org.openqa.selenium.WebDriver;
import utils.ElementFinder;

public class BasePage {

    protected WebDriver driver;
    protected ElementFinder finder;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.finder = new ElementFinder(driver);
    }
}