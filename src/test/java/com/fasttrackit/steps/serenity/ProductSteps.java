package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.LoginPage;
import com.fasttrackit.pages.ProductPage;
import com.fasttrackit.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductSteps extends ScenarioSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private ShopPage shopPage;
    private ProductPage productPage;

    @Step
    public void goToShopTab() {
        homePage.clickShopTab();
    }

    @Step
    public void selectProductFromTheShopList() {
        shopPage.selectProductFromTheShopList();

    }

    @Step
    public void modifyProductQuantity(int quantity) {
        productPage.modifyProductQuantity(quantity);
    }

    @Step
    public void addProductToCart() {
        productPage.clickProductAddToCartButton();
    }

    @Step
    public void verifyReviewCommentIsDisplayed(String reviewTextFromUser) {
        productPage.verifyReviewCommentIsDisplayed(reviewTextFromUser);
    }

    @Step
    public void clickProductReviewButton() {
        productPage.clickProductReviewButton();
    }

    @Step
    public void addReviewForProduct(String commentText) {
        productPage.setProductCommentTextArea(commentText);
    }

    @Step
    public void clickReviewSubmitButton() {
        productPage.clickSubmitReviewButton();
    }

    @Step
    public void clickProductRatingStar() {
        productPage.clickProductRatingStar();
    }

    @Step
    public void verifyCommentMessageForDuplicateReviewExistingInList(String newComment) {
        productPage.verifyCommentMessageForDuplicateReviewExistingInList(newComment);
    }

    @Step
    public void verifyMessageForReviewWithoutBeingLoggedIn() {
        productPage.verifyMessageWhenTryingToAddACommentReviewWithoutBeingLoggedIn();
    }

    @Step
    public void verifyAlertWhenAddingCommentReviewWithoutRating() {
        productPage.addCommentReviewWithoutRating();
    }
}
