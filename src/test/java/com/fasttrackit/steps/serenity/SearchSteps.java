package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.LoginPage;
import com.fasttrackit.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class SearchSteps extends ScenarioSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;

    @Step
    public void goToSearchIcon() {
        searchPage.clickIconSearchButton();
    }

    @Step
    public void setKeywordName(String productName) {
        searchPage.setKeywordNameSearch(productName);
    }

    @Step
    public void clickSubmitSearchButton() {
        searchPage.clickSubmitYourSearchButton();
    }

    @Step
    public void verifyProductInResults(String productName) {
        Assert.assertTrue(searchPage.checkListForProduct(productName));
    }

    @Step
    public void openSearchedProduct(String productName) {
        searchPage.selectProductFromList(productName);
    }

    @Step
    public void checkProductIsNotInList(String productName) {
        searchPage.checkProductIsNotInList(productName);
    }

    @Step
    public void searchForProduct(String productName) {
        goToSearchIcon();
        setKeywordName(productName);
        clickSubmitSearchButton();
    }
}
