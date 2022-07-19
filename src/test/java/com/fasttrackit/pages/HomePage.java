package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa2.fasttrackit.org:8008/")
public class HomePage extends BasePage {

    @FindBy(css = "#menu-item-64 a")
    private WebElementFacade myAccountTab;
    @FindBy(css = "#menu-item-66 a")
    private WebElementFacade shopTab;
    @FindBy(css = "#menu-item-65 a")
    private WebElementFacade checkoutTab;

    public void clickMyAccountTab() {
        clickOn(myAccountTab);
    }

    public void clickShopTab() {
        clickOn(shopTab);
    }

    public void clickCheckoutTab() {
        clickOn(checkoutTab);
    }
}
