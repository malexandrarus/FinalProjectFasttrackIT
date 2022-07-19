package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class ShopTest extends BaseTest {

    @Test
    public void verifyAddProductToCartTest() {
        loginSteps.doLogin();
        shopSteps.goToShopTab();
        shopSteps.selectProductFromTheShopList();
        shopSteps.addSelectedProductToCart();
        shopSteps.verifyMessageAfterProductWasAddedToCart(1);
    }

    @Test
    public void addMultipleProductsToCart() {
        loginSteps.doLogin();
        // add first product
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();

        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
    }

    @Test
    public void addConfiguredProductToCartTest() {
        loginSteps.doLogin();
        shopSteps.goToShopTab();
        shopSteps.verifyProductIsPresentInTheList("Hoodie");
        shopSteps.clickOnSelectOptionsButton();
        shopSteps.selectOptionsFromDropdown("Blue", "No");
        shopSteps.clickAddToCartButtonFromProductPage();
        shopSteps.verifyMessageAfterProductWasAddedToCart(1);
    }

    @Test
    public void openProductWithReadMoreOptionTest() {
        loginSteps.doLogin();
        shopSteps.goToShopTab();
        shopSteps.verifyProductIsPresentInTheList("READ MORE");
    }

    @Test
    public void sortProductByPriceTest() {
        loginSteps.doLogin();
        shopSteps.goToShopTab();
        shopSteps.verifySortByPriceDescending();
    }

    @Test
    public void selectProductFromListUsingAKeywordTest() {
        loginSteps.doLogin();
        shopSteps.goToShopTab();
        shopSteps.selectProductFromListUsingAKeyword("Hoodie with Logo");
        shopSteps.addSelectedProductToCart();
        shopSteps.verifyMessageAfterProductWasAddedToCart(1);
    }
}
