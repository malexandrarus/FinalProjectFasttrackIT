package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.fasttrackit.utils.Constants.*;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentialsTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        loginSteps.checkLoggedIn(USERNAME);
    }

    @Test
    public void loginWithValidCredentialsFollowedByEnterKey() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginWithEnterKey();
        loginSteps.checkLoggedIn(USERNAME);
    }

    @Test
    public void loginWithValidCredentialsFollowedByTheVerificationOfTheUser() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.clickLoginWithEnterKey();
        loginSteps.checkLoggedIn(USERNAME);
    }

    @Test
    public void loginWithoutMandatoryFields() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData("", "");
        loginSteps.clickLoginButton();
        loginSteps.verifyInvalidEmailMessage();
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        loginSteps.setData(email, USER_PASSWORD);
        loginSteps.clickLoginButton();
        loginSteps.invalidCredentialsMessage();
    }

    @Test
    public void loginWithEmptyFields() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.clickLoginButton();
        loginSteps.emptyMandatoryFieldsError();
    }

    @Test
    public void loginWithWrongPassword() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, "Mai@2022");
        loginSteps.clickLoginButton();
        loginSteps.verifyLoginWithIncorrectPassword(USER_EMAIL);
    }

    @Test
    public void lostPasswordTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.lostPassword();
        loginSteps.setEmailForLostPasswordField(USER_EMAIL);
        loginSteps.clickOnResetPasswordButton();
        loginSteps.verifyMessageAfterMandatoryFieldsForResetPasswordWereFilled();
    }

    @Test
    public void resetPasswordWithoutAValidEmailTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.lostPassword();
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        loginSteps.setEmailForLostPasswordField(email);
        loginSteps.clickOnResetPasswordButton();
        loginSteps.verifyInvalidEmailForPasswordResetMessage();
    }

    @Test
    public void rememberMeCheckboxTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.verifyRememberMeCheckbox();
        loginSteps.clickLoginWithEnterKey();
    }
}
