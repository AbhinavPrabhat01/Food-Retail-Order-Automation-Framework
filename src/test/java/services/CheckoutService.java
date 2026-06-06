package services;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.Checkout;
import utils.ConfigReader;
import utils.OrderConfigurationReader;

public class CheckoutService {

    private static final Logger log = LogManager.getLogger(CheckoutService.class);

    private Checkout checkout;

    public CheckoutService(Checkout checkout){
        this.checkout = checkout;
        log.info("🛠️ CheckoutService initialized");
    }

    public void checkoutInfo(){
        log.info("📦 Fetching checkout configuration...");

        JsonNode orders = OrderConfigurationReader.getOrderData("checkout");

        for (JsonNode item : orders){

            log.info("➡️ Processing new checkout data");

            String tip = null;
            String cardNumber = null;
            String expiry = null;
            String cvv = null;
            String zip = null;

            String payment = item.get("payment").asText();
            log.info("💳 Payment type: {}", payment);

            if (payment.equalsIgnoreCase("credit")){
                tip = item.get("tip").asText();
                cardNumber = ConfigReader.get("cardNumber");
                expiry = ConfigReader.get("expiry");
                cvv = ConfigReader.get("cvv");
                zip = ConfigReader.get("zip");

                log.info("💰 Tip: {}", tip);
                log.info("🔐 Card details fetched from config");
            }

            String firstName = item.get("firstName").asText();
            String lastName = item.get("lastName").asText();
            String email = item.get("email").asText();
            String phone = item.get("phone").asText();

            log.info("👤 Customer: {} {}", firstName, lastName);

            checkout.selectPaymentMethod(payment);

            if (payment.equalsIgnoreCase("credit") && tip != null && cardNumber != null &&
                    expiry != null && cvv != null && zip != null){

                log.info("➡️ Executing credit card flow");

                checkout.provideTip(tip);
                checkout.cardDetails(cardNumber,expiry,cvv,firstName,zip);

                log.info("✅ Payment details entered successfully");
            }

            checkout.contactInformation(firstName,lastName,email,phone);
            log.info("✅ Contact information submitted");

            checkout.reviewOrder();
            log.info("✅ Review order step completed");
        }

        log.info("🎯 Checkout flow completed for all entries");
    }
}