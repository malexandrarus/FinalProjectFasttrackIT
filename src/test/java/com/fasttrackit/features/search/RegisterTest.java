package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.fasttrackit.utils.Constants.USER_EMAIL;
import static com.fasttrackit.utils.Constants.USER_PASSWORD;

@RunWith(SerenityRunner.class)
public class RegisterTest extends BaseTest {

    @Test
    public void validRegisterTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        String userName = RandomStringUtils.randomAlphabetic(10);
        String email = userName.concat("@email.com");
        registerSteps.setData(email, USER_PASSWORD);
        registerSteps.clickRegister();
        registerSteps.validateSuccessRegisterElement(userName);
    }

    @Test
    public void registerWithInvalidEmail() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        String email = RandomStringUtils.randomAlphabetic(10) + "email.com";
        registerSteps.setData(email, USER_PASSWORD);
        registerSteps.clickRegister();
        registerSteps.registerWithInvalidEmail(email);
    }

    @Test
    public void registerWithEmailWithoutDotSignTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        String email = RandomStringUtils.randomAlphabetic(10) + "@emailcom";
        registerSteps.setData(email, USER_PASSWORD);
        registerSteps.clickRegister();
        registerSteps.verifyErrorMessageEmailWithoutDotSign();
    }

    @Test
    public void registerWithMandatoryFieldsWithoutFillingAnyDataAndClickOnRegisterTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        registerSteps.setData("", "");
        registerSteps.clickRegister();
        registerSteps.verifyErrorMessageEmptyMandatoryFields();

    }

    @Test
    public void verifyPasswordLengthTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        registerSteps.setData(" ", " ");
        registerSteps.validatePasswordLength();
    }

    @Test
    public void verifyRegisterButtonIsDisabledTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        registerSteps.setData(USER_EMAIL, "bla");
        registerSteps.validateRegisterButtonIsDisabled();
    }

    @Test
    public void verifyRegisterButtonIsEnabledTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        registerSteps.setData(email, USER_PASSWORD);
        registerSteps.validateRegisterButtonIsEnabled();
    }
}
