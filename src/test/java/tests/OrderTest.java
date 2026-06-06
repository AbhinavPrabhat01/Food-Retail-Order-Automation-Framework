package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import services.CheckoutService;
import services.MenuService;
import utils.ConfigReader;

public class OrderTest extends BaseTest {

    @Test
    public void orderProducts(){
        String URL = ConfigReader.get("authURLQA");
        Homepage home = new Homepage(driver);
        home.openWebsite(URL);
        home.clearCart();
        //home.handleCookies();

        Location loc = new Location(driver);
        loc.setLocation();

        Menu menu = new Menu(driver);
        MenuService menuService = new MenuService(menu);
        menu.openMenu();
        menuService.createCartPizzaOnly();
        menu.openCart();

        Cart cart = new Cart(driver);
        cart.checkout();

        Checkout checkout = new Checkout(driver);
        CheckoutService checkoutService = new CheckoutService(checkout);
        checkoutService.checkoutInfo();


    }
}
