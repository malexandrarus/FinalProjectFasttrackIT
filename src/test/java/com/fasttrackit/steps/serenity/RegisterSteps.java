package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RegisterSteps extends ScenarioSteps {

    private HomePage homePage;
    private RegisterPage registerPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToRegisterPage() {
        homePage.clickMyAccountTab();
    }

    @Step
    public void setData(String emailAddress, String password) {
        registerPage.setRegisterEmailField(emailAddress);
        registerPage.setRegisterPasswordField(password);
    }

    @Step
    public void clickRegister() {
        registerPage.clickRegisterButton();
    }

    @Step
    public void validateSuccessRegisterElement(String userName) {
        registerPage.setSuccessRegisterElement(userName);
    }

    @Step
    public void registerWithInvalidEmail(String email) {
        registerPage.registerWithInvalidEmailAddress(email);
    }

    @Step
    public void verifyErrorMessageEmailWithoutDotSign() {
        registerPage.verifyErrorMessageEmailWithoutDotSign();
    }

    @Step
    public void verifyErrorMessageEmptyMandatoryFields() {
        registerPage.verifyErrorMessageEmptyMandatoryFields();
    }

    @Step
    public void validatePasswordLength() {
        registerPage.validatePassword();
    }

    @Step
    public void validateRegisterButtonIsDisabled() {
        registerPage.validateRegisterButtonIsDisabled();
    }

    @Step
    public void validateRegisterButtonIsEnabled() {
        registerPage.validateRegisterButtonIsEnabled();
    }
}
