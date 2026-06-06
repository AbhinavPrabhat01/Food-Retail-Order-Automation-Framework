package pages;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends BasePage {

    private static final Logger log = LogManager.getLogger(Checkout.class);

    public Checkout(WebDriver driver) {
        super(driver);
        log.info("🧾 Checkout page initialized");
    }

    public void selectPaymentMethod(String payment){
        String customXpath = "//span[contains(text(),'"+payment+"')]";

        log.info("💳 Selecting payment method: {}", payment);
        finder.safeClick(By.xpath(customXpath),"Payment Method");
        log.info("✅ Payment method selected: {}", payment);
    }

    public void cardDetails(String cardNumber, String expiry, String cvv, String firstName, String zip){
        log.info("💳 Entering card details");

        finder.safeSendKeys(By.xpath("//input[@id = 'payment.creditCard']"),cardNumber,"Card number");
        finder.safeSendKeys(By.xpath("//input[@name = 'expirationDate']"),expiry,"Expiry");
        finder.safeSendKeys(By.xpath("//input[@name = 'cvv']"),cvv,"CVV");
        finder.safeSendKeys(By.xpath("//input[@name = 'payment.nameCard']"),firstName,"Cardholder name");
        finder.safeSendKeys(By.xpath("//input[@name = 'payment.billingPostalCode']"),zip,"Postal Code");

        log.info("✅ Card details entered successfully");
    }

    public void provideTip(String tip){
        log.info("💰 Providing tip: {}", tip);

        finder.safeSendKeys(By.xpath("//input[@placeholder='Enter a custom amount']"),tip,"Tip input");
        finder.safeClick(By.xpath("//input[@placeholder='Enter a custom amount']/following-sibling::button"),"Tip Apply Button");

        log.info("✅ Tip applied successfully");
    }

    public void contactInformation(String firstName, String lastName, String email, String phone){
        log.info("📇 Entering contact information");

        finder.safeSendKeys(By.xpath("//input[@name='contactInfo.firstName']"),firstName,"First Name field");
        finder.safeSendKeys(By.xpath("//input[@name='contactInfo.lastName']"),lastName,"Last Name field");
        finder.safeSendKeys(By.xpath("//input[@name='contactInfo.email']"),email,"Email field");
        finder.safeSendKeys(By.xpath("//input[@placeholder='(___) ___-____']"),phone,"Phone field");

        log.info("✅ Contact information entered successfully");
    }

    public void reviewOrder(){
        log.info("📝 Reviewing order");

        finder.safeClickIfPresent(By.xpath("//input[@name='policyCheck']"),"Policy Check");
        finder.safeClick(By.xpath("//button[.//span[text()='Review order']]"),"Review button");

        log.info("✅ Review order clicked successfully");
    }
}