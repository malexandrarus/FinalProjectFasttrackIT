package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.LoginPage;
import com.fasttrackit.pages.SearchPage;
import com.fasttrackit.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class ShopSteps extends ScenarioSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private ShopPage shopPage;

    @Step
    public void goToShopTab() {
        homePage.clickShopTab();
    }

    @Step
    public void selectProductFromTheShopList() {
        shopPage.selectProductFromTheShopList();

    }

    @Step
    public void addSelectedProductToCart() {
        shopPage.addProductToCart();
    }

    @Step
    public void viewDetailsForProductUsingEditIconAfterSearch() {
        shopPage.clickEditIconForProductAfterSearch();
    }

    @Step
    public void verifyMessageAfterProductWasAddedToCart(Integer quantity) {
        Assert.assertTrue(shopPage.verifyMessageAfterProductWasAddedToCart(quantity));
    }

    @Step
    public void verifyProductIsPresentInTheList(String text) {
        shopPage.verifyProductIsPresentInTheList(text);
    }

    @Step
    public void clickOnSelectOptionsButton() {
        shopPage.clickOnSelectOptionsButton();
    }

    @Step
    public void selectOptionsFromDropdown(String colorValue, String logoValue) {
        shopPage.selectColorFromDropdown(colorValue);
        shopPage.selectLogoFromDropdown(logoValue);
    }

    @Step
    public void clickAddToCartButtonFromProductPage() {
        shopPage.clickAddToCartButtonFromProductPage();
    }

    @Step
    public void setSortByPrice() {
        shopPage.setSortByDropdown("Sort by price: high to low");
    }

    @Step
    public void verifySortByPriceDescending() {
        setSortByPrice();
        Assert.assertTrue("Price is ordered descending!",
                shopPage.isSortByPriceDescending());
    }

    @Step
    public void selectProductFromListUsingAKeyword(String productName) {
        shopPage.selectProductFromListUsingAKeyword(productName);
    }

    @Step
    public void addProductToCart() {
        viewDetailsForProductUsingEditIconAfterSearch();
        addSelectedProductToCart();
    }
}
