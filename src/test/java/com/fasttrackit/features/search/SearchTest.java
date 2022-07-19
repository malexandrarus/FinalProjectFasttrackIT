package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.fasttrackit.utils.Constants.USER_EMAIL;
import static com.fasttrackit.utils.Constants.USER_PASSWORD;

@RunWith(SerenityRunner.class)
public class SearchTest extends BaseTest {

    @Test
    public void searchProductTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        searchSteps.goToSearchIcon();
        searchSteps.setKeywordName("T-shirt");
        searchSteps.clickSubmitSearchButton();
        searchSteps.verifyProductInResults("V-NECK T-SHIRT");
    }

    @Test
    public void openSearchedProductTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        searchSteps.goToSearchIcon();
        searchSteps.setKeywordName("T-shirt");
        searchSteps.clickSubmitSearchButton();
        searchSteps.openSearchedProduct("V-NECK T-SHIRT");
    }

    @Test
    public void checkProductIsNotInListTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setData(USER_EMAIL, USER_PASSWORD);
        loginSteps.checkRememberMeCheckbox();
        loginSteps.clickLoginButton();
        searchSteps.goToSearchIcon();
        searchSteps.setKeywordName("bread");
        searchSteps.clickSubmitSearchButton();
        searchSteps.checkProductIsNotInList("bread");

    }
}
