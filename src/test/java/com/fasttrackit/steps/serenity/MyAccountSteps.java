package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.LoginPage;
import com.fasttrackit.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyAccountSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Step
    public void goToMyAccountTab() {
        homePage.clickMyAccountTab();
    }

    @Step
    public void goToMyOrderTab() {
        myAccountPage.verifyOrderTab();
    }

    @Step
    public void verifyIfOrderElementIsDisplayedOnPage() {
        myAccountPage.verifyIfOrderElementIsDisplayedOnPage();
    }

    @Step
    public void goToMyDownloadTab() {
        myAccountPage.verifyDownloadTab();
    }

    @Step
    public void verifyIfDownloadElementIsDisplayedOnPage() {
        myAccountPage.verifyIfDownloadElementIsDisplayedOnPage();
    }

    @Step
    public void goToMyAddressTab() {
        myAccountPage.verifyAddressTab();
    }

    @Step
    public void verifyIfAddressElementIsDisplayedOnPage() {
        myAccountPage.verifyIfAddressElementIsDisplayedOnPage();
    }

    @Step
    public void goToMyAccountDetailsTab() {
        myAccountPage.verifyAccountDetailsTab();
    }

    @Step
    public void verifyOfAccountDetailsElementIsDisplayedOnPage() {
        myAccountPage.verifyOfAccountDetailsElementIsDisplayedOnPage();
    }

    @Step
    public void clickLogoutButton() {
        myAccountPage.clickLogout();
    }
    @Step
    public void verifyThatAfterLogoutUserIsRedirectedToLoginPage() {
        myAccountPage.verifyThatAfterLogoutUserIsRedirectedToLoginPage();
    }

    @Step
    public void verifyIfNextButtonFromOrdersPageIsDisplayedAndCanBeClicked() {
        myAccountPage.verifyIfNextButtonFromOrdersPageIsDisplayedAndCanBeClicked();
    }

    @Step
    public void verifyThatAfterViewButtonForAnOrderIsClickedTheOrderDetailsPageIsDisplayed() {
        myAccountPage.verifyThatAfterViewButtonForAnOrderIsClickedTheOrderDetailsPageIsDisplayed();
    }

    @Step
    public void verifyMessageForNoPlaceOrderForNewUser() {
        myAccountPage.verifyMessageForNoPlaceOrderForNewUser();
    }
}
