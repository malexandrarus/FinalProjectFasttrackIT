package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAccountPage extends BasePage {

    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloMessage;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--orders a")
    private WebElementFacade orderTab;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--downloads a")
    private WebElementFacade downloadTab;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-address a")
    private WebElementFacade addressTab;
    @FindBy(css = "woocommerce-MyAccount-navigation-link--edit-account")
    private WebElementFacade accountDetailsTab;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout a")
    private WebElementFacade logoutButton;

    public boolean verifyUserLoggedIn(String text) {
        return helloMessage.containsOnlyText("Hello " + text + " (not " + text + "? Log out)");
    }
}
