package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CartTest extends BaseTest {


    @Before
    public void setUp() {
        // make sure to delete all previous data from cart
        loginSteps.doLogin();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.removeFromCart();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.clickLogoutButton();
    }

    @Test
    public void navigateToCartUsingVieCartButtonFromProductDetailsPageTest() {
        loginSteps.doLogin();
        shopSteps.goToShopTab();
        shopSteps.selectProductFromTheShopList();
        shopSteps.addSelectedProductToCart();
        cartSteps.clickViewCartButtonFromAddToCartMessageInfoAfterProductWasAddedToCart();
        cartSteps.verifyElementOnPageAfterViewCartButtonWasPressed();
    }

    @Test
    public void addQuantityToProductAddedToCartTest() {
        int quantity = 3;
        String productName = "Album";

        loginSteps.doLogin();
        shopSteps.goToShopTab();
        shopSteps.selectProductFromTheShopList();
        shopSteps.addSelectedProductToCart();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.modifyQuantityForProductAddedToCart(quantity, productName);
        cartSteps.verifyMessageAfterCartWasUpdated();
    }

    @Test
    public void removeProductFromCartTest() {
        String productName = "“Beanie with Logo”";

        loginSteps.doLogin();
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.removeSingleProductFromCart();
        cartSteps.verifyRemovedProductFromCartMessage(productName);
    }

    @Test
    public void removeProductOneByOneFromCartTest() {
        loginSteps.doLogin();
        // add products to cart section
        // add first product
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();

        // go to cart and remove products
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.removeFromCart();
    }

    @Test
    public void checkCartTotalSummaryTest() {
        loginSteps.doLogin();
        // add first product
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();

        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.checkSubtotalPriceIsDisplayedCorrectly();
        cartSteps.checkTotalPriceIsCorrect();
    }

    @Test
    public void verifyCouponCodeIsAppliedToProductsUnderTheShoppingCartTest() {
        loginSteps.doLogin();
        // add first product
        searchSteps.searchForProduct("Hoodie with Logo");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();

        // add second product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Long Sleeve Tee");
        shopSteps.addProductToCart();

        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.setCouponCode("HOODIETEE");
        cartSteps.clickApplyCouponButton();
        cartSteps.verifyCouponCodeSuccessfullyAppliedMessage();
    }
}
