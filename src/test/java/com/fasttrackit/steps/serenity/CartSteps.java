package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertTrue;

public class CartSteps extends ScenarioSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private ShopPage shopPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Step
    public void clickViewCartButtonFromAddToCartMessageInfoAfterProductWasAddedToCart() {
        cartPage.clickViewCartButtonFromAddToCartMessageInfo();
    }

    @Step
    public void verifyElementOnPageAfterViewCartButtonWasPressed() {
        cartPage.verifyElementIsVisibleOnPage();
    }

    @Step
    public void clickViewYourShoppingCartButton() {
        cartPage.clickViewYourShoppingCartButton();
    }

    @Step
    public void modifyQuantityForProductAddedToCart(int quantity, String productName) {
        cartPage.addQuantityToProduct(quantity, productName);
    }

    @Step
    public void verifyMessageAfterCartWasUpdated() {
        cartPage.verifyMessageAfterCartWasUpdated();
    }

    @Step
    public void removeFromCart() {
        cartPage.removeProductsFromCart();
    }

    @Step
    public void removeSingleProductFromCart() {
        cartPage.removeSingleProductFromCart();
    }

    @Step
    public void verifyRemovedProductFromCartMessage(String productName) {
        cartPage.verifyRemovedProductFromCartMessage(productName);
    }

    @Step
    public void verifyAddedProductsArePresentInTheCart() {
        cartPage.verifyAddedProductsArePresentInTheCart();
    }

    @Step
    public void checkSubtotalPriceIsDisplayedCorrectly(){
        assertTrue("The subtotal price is not correct!", cartPage.isSubtotalPriceCorrect());
    }

    @Step
    public void checkTotalPriceIsCorrect(){
        assertTrue("Total price not correct", cartPage.isTotalPriceCorrect());
    }

    @Step
    public void setCouponCode(String couponCodeName) {
        cartPage.setCouponCode(couponCodeName);
    }

    @Step
    public void clickApplyCouponButton() {
        cartPage.clickApplyCouponButton();
    }

    @Step
    public void verifyCouponCodeSuccessfullyAppliedMessage() {
        cartPage.verifyCouponCodeSuccessfullyAppliedMessage();
    }

    @Step
    public void clickProceedToCheckoutButtonFromCart() {
        cartPage.clickProceedToCheckoutButtonFromCart();
    }
}