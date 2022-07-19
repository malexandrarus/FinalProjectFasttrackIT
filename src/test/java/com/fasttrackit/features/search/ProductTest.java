package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.fasttrackit.utils.Constants.USER_EMAIL;
import static com.fasttrackit.utils.Constants.USER_PASSWORD;

@RunWith(SerenityRunner.class)
public class ProductTest extends BaseTest {

    @Test
    public void verifyIfProductCanBeAddedToCartFromProductPageTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        productSteps.goToShopTab();
        productSteps.selectProductFromTheShopList();
        productSteps.addProductToCart();
        shopSteps.verifyMessageAfterProductWasAddedToCart(1);
    }

    @Test
    public void verifyIfQuantityCanBeModifiedFromTheProductPageTest() {
        int quantity = 3;

        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        productSteps.goToShopTab();
        productSteps.selectProductFromTheShopList();
        productSteps.modifyProductQuantity(quantity);
        productSteps.addProductToCart();
        shopSteps.verifyMessageAfterProductWasAddedToCart(quantity);
    }

    @Test
    public void addReviewForProductTest() {
        String commentMessage = "Very Good ".concat(RandomStringUtils.randomAlphabetic(5));

        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        productSteps.goToShopTab();
        productSteps.selectProductFromTheShopList();
        productSteps.clickProductReviewButton();
        productSteps.addReviewForProduct(commentMessage);
        productSteps.clickProductRatingStar();
        productSteps.clickReviewSubmitButton();
        productSteps.verifyReviewCommentIsDisplayed(commentMessage);
    }

    @Test
    public void verifyCommentMessageForDuplicateReviewTest() {
        String newComment = "nice";

        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        productSteps.goToShopTab();
        productSteps.selectProductFromTheShopList();
        productSteps.clickProductReviewButton();
        productSteps.addReviewForProduct(newComment);
        productSteps.clickProductRatingStar();
        productSteps.verifyCommentMessageForDuplicateReviewExistingInList(newComment);
    }

    @Test
    public void verifyMessageWhenTryingToAddAReviewCommentWithoutBeingLoggedInTest() {
        loginSteps.navigateToHomepage();
        productSteps.goToShopTab();
        productSteps.selectProductFromTheShopList();
        productSteps.clickProductReviewButton();
        productSteps.verifyMessageForReviewWithoutBeingLoggedIn();
    }

    @Test
    public void addCommentMessageWithoutAddingRatingForProductTest() {
        String commentMessage = "Very Good ".concat(RandomStringUtils.randomAlphabetic(5));

        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        productSteps.goToShopTab();
        productSteps.selectProductFromTheShopList();
        productSteps.clickProductReviewButton();
        productSteps.addReviewForProduct(commentMessage);
        productSteps.verifyAlertWhenAddingCommentReviewWithoutRating();
    }
}
