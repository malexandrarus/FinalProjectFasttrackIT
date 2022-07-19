package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RegisterPage extends BasePage {

    @FindBy(id = "reg_email")
    private WebElementFacade registerEmailField;
    @FindBy(id = "reg_password")
    private WebElementFacade registerPasswordField;
    @FindBy(css = "[value = Register]")
    private WebElementFacade registerButton;
    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade successRegisterElement;
    @FindBy(id = "reg_email")
    private WebElement registerPopUpMessage;
    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorMessageEmailWithoutDotSign;
    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorMessageEmptyMandatoryFields;
    @FindBy(css = ".woocommerce-password-hint")
    private WebElementFacade alertPasswordValidation;
    @FindBy(css = "[disabled = disabled]")
    private WebElementFacade registerButtonDisabled;
    @FindBy(css = "[name = register]")
    private WebElementFacade registerButtonEnabled;

    public void setRegisterEmailField(String registerEmail) {
        typeInto(registerEmailField, registerEmail);
    }

    public void setRegisterPasswordField(String passwordField) {
        typeInto(registerPasswordField, passwordField);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void setSuccessRegisterElement(String userName) {
        successRegisterElement.shouldContainOnlyText("Hello " + userName + " (not " + userName + "? Log out)");
    }

    public void registerWithInvalidEmailAddress(String email) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Boolean isValidInput = (Boolean) js.executeScript("return arguments[0].checkValidity();", registerPopUpMessage);
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", registerPopUpMessage);

        assertEquals(String.format("Please include an '@' in the email address. '%s' is missing an '@'.", email), validationMessage);
        assertFalse(isValidInput);
    }

    public void verifyErrorMessageEmailWithoutDotSign() {
        errorMessageEmailWithoutDotSign.shouldContainOnlyText("Error: Please provide a valid email address.");
    }

    public void verifyErrorMessageEmptyMandatoryFields() {
        errorMessageEmptyMandatoryFields.shouldContainOnlyText("Error: Please provide a valid email address.");
    }

    public void validatePassword() {
        alertPasswordValidation.shouldContainOnlyText("Hint: The password should be at least twelve characters long. To make it stronger, use upper and lower case letters, numbers, and symbols like ! \" ? $ % ^ & ).");
    }

    public void validateRegisterButtonIsDisabled() {
        registerButtonDisabled.isDisabled();
    }

    public void validateRegisterButtonIsEnabled() {
        registerButtonEnabled.click();
    }
}
