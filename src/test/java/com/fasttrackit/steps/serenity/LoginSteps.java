package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.LoginPage;
import com.fasttrackit.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static com.fasttrackit.utils.Constants.USER_EMAIL;
import static com.fasttrackit.utils.Constants.USER_PASSWORD;

public class LoginSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToLogin() {
        homePage.clickMyAccountTab();
    }

    @Step
    public void setData(String emailAddress, String password) {
        loginPage.setUsernameField(emailAddress);
        loginPage.setPasswordField(password);
    }

    @Step
    public void checkRememberMeCheckbox() {
        loginPage.checkRememberMeField();
    }

    @Step
    public void verifyRememberMeCheckbox() {
        loginPage.verifyCheckboxIsCheckedOrNot();
    }

    @Step
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step
    public void clickLoginWithEnterKey() {
        loginPage.clickLoginWithEnterKey();

    }

    @Step
    public void checkLoggedIn(String username) {
        Assert.assertTrue(myAccountPage.verifyUserLoggedIn(username));
    }

    @Step
    public void verifyInvalidEmailMessage() {
        loginPage.verifyInvalidEmailMessage();
    }

    @Step
    public void invalidCredentialsMessage() {
        loginPage.verifyInvalidCredentialsMessage();
    }

    @Step
    public void emptyMandatoryFieldsError() {
        loginPage.verifyEmptyMandatoryFieldsError();
    }

    @Step
    public void verifyLoginWithIncorrectPassword(String username) {
        Assert.assertTrue(loginPage.verifyWrongPasswordError(username));
    }

    @Step
    public void lostPassword() {
        loginPage.lostPassword();

    }

    @Step
    public void setEmailForLostPasswordField(String email) {
        loginPage.setUsernameOrEmailFieldForLostPassword(email);
    }

    @Step
    public void clickOnResetPasswordButton() {
        loginPage.clickResetPasswordButtonAfterFillingTheEmail();
    }

    @Step
    public void verifyMessageAfterMandatoryFieldsForResetPasswordWereFilled() {
        loginPage.verifyMessageForLostPassword();
    }

    @Step
    public void verifyInvalidEmailForPasswordResetMessage() {
        loginPage.verifyInvalidEmailForPasswordResetMessage();
    }

    @Step
    public void doLogin() {
        navigateToHomepage();
        navigateToLogin();
        setData(USER_EMAIL, USER_PASSWORD);
        checkRememberMeCheckbox();
        clickLoginButton();
    }

}
