package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class MyAccountTest extends BaseTest {

    @Test
    public void goToMyOrderTest() {
        loginSteps.doLogin();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.goToMyOrderTab();
        myAccountSteps.verifyIfOrderElementIsDisplayedOnPage();
    }

    @Test
    public void goToMyDownloadTabTest() {
        loginSteps.doLogin();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.goToMyDownloadTab();
        myAccountSteps.verifyIfDownloadElementIsDisplayedOnPage();
    }

    @Test
    public void goToMyAddressTabTest() {
        loginSteps.doLogin();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.goToMyAddressTab();
        myAccountSteps.verifyIfAddressElementIsDisplayedOnPage();
    }

    @Test
    public void goToMyAccountDetailsTabTest() {
        loginSteps.doLogin();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.goToMyAccountDetailsTab();
        myAccountSteps.verifyOfAccountDetailsElementIsDisplayedOnPage();
    }

    @Test
    public void clickingOnLogoutButtonUserIsRedirectedToLoginPageTest() {
        loginSteps.doLogin();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.clickLogoutButton();
        myAccountSteps.verifyThatAfterLogoutUserIsRedirectedToLoginPage();
    }

    @Test
    public void verifyIfNextButtonFromOrdersPageIsDisplayedAndCanBeClickedTest() {
        loginSteps.doLogin();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.goToMyOrderTab();
        myAccountSteps.verifyIfOrderElementIsDisplayedOnPage();
        myAccountSteps.verifyIfNextButtonFromOrdersPageIsDisplayedAndCanBeClicked();
    }

    @Test
    public void verifyThatAfterViewButtonForAnOrderIsClickedTheOrderDetailsPageIsDisplayedTest() {
        loginSteps.doLogin();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.goToMyOrderTab();
        myAccountSteps.verifyIfOrderElementIsDisplayedOnPage();
        myAccountSteps.verifyThatAfterViewButtonForAnOrderIsClickedTheOrderDetailsPageIsDisplayed();
    }

    @Test
    public void verifyMessageForNoPlaceOrderForNewUserTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData("b.a@gmail.com", "Abecedar12@");
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        myAccountSteps.goToMyAccountTab();
        myAccountSteps.goToMyOrderTab();
        myAccountSteps.verifyMessageForNoPlaceOrderForNewUser();
    }
}
