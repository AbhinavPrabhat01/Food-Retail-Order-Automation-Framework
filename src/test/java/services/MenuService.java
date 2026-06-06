package services;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.Menu;
import utils.OrderConfigurationReader;

public class MenuService {

    private static final Logger log = LogManager.getLogger(MenuService.class);

    private Menu menu;

    public MenuService(Menu menu){
        this.menu = menu;
    }

    public void createCart(){
        log.info("🛒 Starting cart creation via MenuService");

        JsonNode orders = OrderConfigurationReader.getOrderData("order");

        for (JsonNode item : orders){

            String category = item.get("category").asText();
            String product = item.get("product").asText();
            int quantity = item.get("quantity").asInt();

            log.info("➡️ Processing item → Category: {}, Product: {}, Quantity: {}",
                    category, product, quantity);

            menu.selectCategory(category);
            menu.selectProduct(product);
            menu.selectQuantity(quantity);
            menu.addToOrder();
        }

        log.info("✅ Cart creation completed via MenuService");
    }

    public void createCartPizzaOnly(){

        log.info("🍕 Starting order: Only Pizza");


        JsonNode orders = OrderConfigurationReader.getOrderData("order");

        for (JsonNode item : orders){

            String category = item.get("category").asText();

            if(!category.equalsIgnoreCase("pizza")){
                continue;
            }

            String product = item.get("product").asText();
            int quantity = item.get("quantity").asInt();
            log.info("➡️ Pizza Item → Product: {}, Quantity: {}", product, quantity);
            menu.selectCategory(category);
            menu.selectProduct(product);
            menu.selectQuantity(quantity);
            menu.addToOrder();
        }
        log.info("✅ Pizza-only order completed");
    }
}
