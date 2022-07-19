package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(css = ".icon-search:first-child")
    private WebElementFacade iconSearchButton;
    @FindBy(css = ".search-form [name = s]")
    private WebElementFacade searchBox;
    @FindBy(css = "[type = Submit]")
    private WebElementFacade searchSubmitButton;
    @FindBy(css = ".site-main article")
    private List<WebElementFacade> productListAfterSearch;
    @FindBy(css = ".page-content p")
    private WebElementFacade notFoundProductMessage;

    public void clickIconSearchButton() {
        clickOn(iconSearchButton);
    }

    public void setKeywordNameSearch(String productName) {
        typeInto(searchBox, productName);
    }

    public void clickSubmitYourSearchButton() {
        clickOn(searchSubmitButton);
    }

    public boolean checkListForProduct(String productName) {
        for (WebElementFacade element : productListAfterSearch) {
            if (element.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean selectProductFromList(String product) {
        for (WebElementFacade element : productListAfterSearch) {
            if (element.getText().contains(product)) {
                element.click();
                break;
            }
        }
        return false;
    }

    public void checkProductIsNotInList(String productName) {
        notFoundProductMessage.shouldContainOnlyText("Sorry, but nothing matched your search terms. Please try again with some different keywords.");
    }
}
