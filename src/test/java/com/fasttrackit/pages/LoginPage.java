package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;


public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElementFacade usernameField;
    @FindBy(id = "password")
    private WebElementFacade passwordField;
    @FindBy(id = "rememberme")
    private WebElementFacade rememberMeCheckbox;
    @FindBy(css = "[value = 'Login']")
    private WebElementFacade loginButton;
    @FindBy(css = ".woocommerce-LostPassword a")
    private WebElementFacade lostPasswordButton;
    @FindBy(id = "user_login")
    private WebElementFacade lostPasswordUsernameOrEmail;
    @FindBy(css = "[value = 'Reset password']")
    private WebElementFacade resetPasswordButton;
    @FindBy(css = ".woocommerce-error")
    private WebElementFacade invalidEmailError;
    @FindBy(css = ".woocommerce-error")
    private WebElementFacade invalidCredentialsError;
    @FindBy(css = ".woocommerce-error")
    private WebElementFacade emptyMandatoryFieldsError;
    @FindBy(css = ".woocommerce-error li:first-child")
    private WebElementFacade wrongPasswordError;
    @FindBy(css = "div.woocommerce-message")
    private WebElementFacade resetPasswordMessage;
    @FindBy(css = ".woocommerce-error")
    private WebElementFacade invalidEmailForPasswordResetMessage;

    public void setUsernameField(String username) {
        typeInto(usernameField, username);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }

    public void checkRememberMeField() {
        clickOn(rememberMeCheckbox);
    }

    public boolean verifyCheckboxIsCheckedOrNot() {
        boolean isSelected = rememberMeCheckbox.isSelected();
        if (isSelected == false) {
            rememberMeCheckbox.click();
        }
        return true;
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void lostPassword() {
        clickOn(lostPasswordButton);
    }

    public void setUsernameOrEmailFieldForLostPassword(String email) {
        lostPasswordUsernameOrEmail.sendKeys(email);
    }

    public void clickResetPasswordButtonAfterFillingTheEmail() {
        resetPasswordButton.click();
    }

    public void verifyMessageForLostPassword() {
        resetPasswordMessage.shouldContainOnlyText("Password reset email has been sent.");
    }

    public void clickLoginWithEnterKey() {
        loginButton.sendKeys(Keys.ENTER);
    }

    public void verifyInvalidEmailMessage() {
        invalidEmailError.shouldContainOnlyText("Error: Username is required.");
    }

    public void verifyInvalidCredentialsMessage() {
        invalidCredentialsError.shouldContainOnlyText("ERROR: Invalid email address. Lost your password?");

    }

    public void verifyEmptyMandatoryFieldsError() {
        emptyMandatoryFieldsError.shouldContainOnlyText("Error: Username is required.");
    }

    public boolean verifyWrongPasswordError(String text) {
        return wrongPasswordError.containsOnlyText("ERROR: The password you entered for the email address " + text + " is incorrect. Lost your password?");
    }

    public void verifyInvalidEmailForPasswordResetMessage() {
        invalidEmailForPasswordResetMessage.shouldContainOnlyText("Invalid username or email.");
    }
}
