package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.*;

public class MyAccountPage extends BasePage {

    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloMessage;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--orders a")
    private WebElementFacade orderTab;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--downloads a")
    private WebElementFacade downloadTab;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-address a")
    private WebElementFacade addressTab;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-account a")
    private WebElementFacade accountDetailsTab;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout a")
    private WebElementFacade logoutButton;
    @FindBy(css = ".entry-header .entry-title ")
    private WebElementFacade orderElementExistingOnPage;
    @FindBy(css = ".entry-header .entry-title")
    private WebElementFacade downloadElementExistingOnPage;
    @FindBy(css = ".entry-header .entry-title")
    private WebElementFacade addressElementExistingOnPage;
    @FindBy(css = ".entry-header .entry-title")
    private WebElementFacade accountDetailsElementExistingOnPage;
    @FindBy(css = ".col-1 h2")
    private WebElementFacade redirectToLogin;
    @FindBy(css = ".woocommerce-Button--next")
    private WebElementFacade nextButtonFromAccountDetailsPage;
    @FindBy(css = ".woocommerce-Button--previous")
    private WebElementFacade previousButtonFromAccountDetailsPage;
    @FindBy(css = ".account-orders-table .woocommerce-orders-table__cell-order-actions")
    private List<WebElementFacade> viewOrderButtonListFromMyAccount;
    @FindBy(css = ".woocommerce-order-details .woocommerce-order-details__title")
    private WebElementFacade orderDetailsElement;
    @FindBy(css = ".woocommerce-info")
    private WebElementFacade infoMessageForNoPlacedOrder;
    @FindBy(css = ".woocommerce-info a")
    private WebElementFacade goToShopButton;


    public boolean verifyUserLoggedIn(String text) {
        return helloMessage.containsOnlyText("Hello " + text + " (not " + text + "? Log out)");
    }

    public void verifyOrderTab() {
        clickOn(orderTab);
    }

    public void verifyDownloadTab() {
        clickOn(downloadTab);
    }

    public void verifyAddressTab() {
        clickOn(addressTab);
    }

    public void verifyAccountDetailsTab() {
        clickOn(accountDetailsTab);
    }

    public void clickLogout() {
        clickOn(logoutButton);
    }

    public void verifyIfOrderElementIsDisplayedOnPage() {
        orderElementExistingOnPage.shouldContainOnlyText("ORDERS");
    }

    public void verifyIfDownloadElementIsDisplayedOnPage() {
        downloadElementExistingOnPage.shouldContainOnlyText("DOWNLOADS");
    }

    public void verifyIfAddressElementIsDisplayedOnPage() {
        assertTrue(addressElementExistingOnPage.getText().equalsIgnoreCase("ADDRESSES"));
    }

    public void verifyOfAccountDetailsElementIsDisplayedOnPage() {
        assertTrue(accountDetailsElementExistingOnPage.getText().equalsIgnoreCase("ACCOUNT DETAILS"));
    }

    public void verifyThatAfterLogoutUserIsRedirectedToLoginPage() {
        assertEquals("Login", redirectToLogin.getText());
    }

    public void verifyIfNextButtonFromOrdersPageIsDisplayedAndCanBeClicked() {
        if (nextButtonFromAccountDetailsPage.isDisplayed()) {
            nextButtonFromAccountDetailsPage.click();
            assertTrue(previousButtonFromAccountDetailsPage.isDisplayed());
        } else {
            assertFalse(nextButtonFromAccountDetailsPage.isDisplayed());
        }
    }

    public void verifyThatAfterViewButtonForAnOrderIsClickedTheOrderDetailsPageIsDisplayed() {
        viewOrderButtonListFromMyAccount.get(0).click();
        assertEquals("Order details", orderDetailsElement.getText());
    }

    public void verifyMessageForNoPlaceOrderForNewUser() {
        Assert.assertTrue(viewOrderButtonListFromMyAccount.isEmpty());
        Assert.assertTrue(infoMessageForNoPlacedOrder.getText().contains("No order has been made yet."));
        goToShopButton.click();
    }
}
