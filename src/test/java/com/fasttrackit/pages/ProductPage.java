package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductPage extends BasePage {

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade productAddToCartButton;
    @FindBy(css = "[title='Qty']")
    private WebElementFacade productQuantity;
    @FindBy(id = "tab-title-reviews")
    private WebElementFacade productReviewButton;
    @FindBy(css = "[name='comment']")
    private WebElementFacade productCommentTextArea;
    @FindBy(css = ".star-5")
    private WebElementFacade productRatingStar;
    @FindBy(css = ".must-log-in")
    private WebElementFacade mustLoginMessageForReview;
    @FindBy(css = ".form-submit [value='Submit']")
    private WebElementFacade submitReviewButton;
    @FindBy(css = ".commentlist .description")
    private List<WebElementFacade> reviewList;
    @FindBy(id = "error-page")
    private WebElementFacade errorMessageForDuplicateComment;
    @FindBy(id = "error-page a")
    private WebElementFacade errorPageBackButton;
    @FindBy(css = ".must-log-in")
    private WebElementFacade mustBeLoggedInMessage;

    public void clickProductAddToCartButton() {
        clickOn(productAddToCartButton);
    }

    public void modifyProductQuantity(int quantity) {
        productQuantity.click();
        typeInto(productQuantity, String.valueOf(quantity));
    }

    public void clickSubmitReviewButton() {
        clickOn(submitReviewButton);
    }


    public void verifyReviewCommentIsDisplayed(String reviewTextFromUser) {
        String reviewText = reviewList.get(reviewList.size() - 1).getText();
        Assert.assertTrue(reviewText.contains(reviewTextFromUser));
    }

    public void clickProductReviewButton() {
        clickOn(productReviewButton);
    }

    public void setProductCommentTextArea(String commentText) {
        typeInto(productCommentTextArea, commentText);
    }

    public void clickProductRatingStar() {
        clickOn(productRatingStar);
    }

    public void verifyCommentMessageForDuplicateReviewExistingInList(String newComment) {
        for (WebElementFacade comment : reviewList) {
            if (comment.getText().equals(newComment)) {
                clickOn(submitReviewButton);
                assertTrue(errorMessageForDuplicateComment.getText().startsWith("Duplicate comment detected; it looks as though you’ve already said that!"));
                break;
            }
        }
    }

    public void verifyMessageWhenTryingToAddACommentReviewWithoutBeingLoggedIn() {
        mustBeLoggedInMessage.shouldContainOnlyText("You must be logged in to post a review.");
    }

    public void addCommentReviewWithoutRating() {
        submitReviewButton.click();
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        assertEquals("Please select a rating", alertText);
    }
}
