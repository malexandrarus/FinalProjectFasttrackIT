package com.fasttrackit.steps.serenity;

import com.fasttrackit.model.CheckoutBillingInformation;
import com.fasttrackit.model.CheckoutShippingInformation;
import com.fasttrackit.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckoutSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private ShopPage shopPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Step
    public void setCheckoutBillingInformation(CheckoutBillingInformation checkoutBillingInformation) {
        checkoutPage.setCheckoutBillingFirstName(checkoutBillingInformation.getCheckoutBillingFirstName());
        checkoutPage.setCheckoutBillingLastName(checkoutBillingInformation.getCheckoutBillingLastName());
        checkoutPage.setCheckoutBillingCompanyName(checkoutBillingInformation.getCheckoutBillingCompanyName());
        checkoutPage.selectCheckoutBillingCountryName(checkoutBillingInformation.getCheckoutBillingCountryName());
        checkoutPage.setFirstCheckoutBillingStreetAddressName(checkoutBillingInformation.getCheckoutFirstBillingStreetAddressName());
        checkoutPage.setSecondCheckoutBillingStreetAddressName(checkoutBillingInformation.getCheckoutSecondBillingStreetAddressName());
        checkoutPage.setCheckoutBillingCityName(checkoutBillingInformation.getCheckoutBillingTownCityName());
        checkoutPage.selectCheckoutBillingCountyName(checkoutBillingInformation.getCheckoutBillingCountyName());
        checkoutPage.setCheckoutBillingPostCodeNumber(checkoutBillingInformation.getCheckoutBillingPostcodeZipNumber());
        checkoutPage.setCheckoutBillingPhoneNumber(checkoutBillingInformation.getCheckoutBillingPhoneNumber());
        checkoutPage.setCheckoutBillingEmailAddress(checkoutBillingInformation.getCheckoutBillingEmailAddress());
    }

    @Step
    public void setCheckoutBillingInformationForTextFieldCounty(CheckoutBillingInformation checkoutBillingInformation) {
        checkoutPage.setCheckoutBillingFirstName(checkoutBillingInformation.getCheckoutBillingFirstName());
        checkoutPage.setCheckoutBillingLastName(checkoutBillingInformation.getCheckoutBillingLastName());
        checkoutPage.setCheckoutBillingCompanyName(checkoutBillingInformation.getCheckoutBillingCompanyName());
        checkoutPage.selectCheckoutBillingCountryName(checkoutBillingInformation.getCheckoutBillingCountryName());
        checkoutPage.setFirstCheckoutBillingStreetAddressName(checkoutBillingInformation.getCheckoutFirstBillingStreetAddressName());
        checkoutPage.setSecondCheckoutBillingStreetAddressName(checkoutBillingInformation.getCheckoutSecondBillingStreetAddressName());
        checkoutPage.setCheckoutBillingCityName(checkoutBillingInformation.getCheckoutBillingTownCityName());
        checkoutPage.setCheckoutBillingTextFieldCountyName(checkoutBillingInformation.getCheckoutBillingCountyName());
        checkoutPage.setCheckoutBillingPostCodeNumber(checkoutBillingInformation.getCheckoutBillingPostcodeZipNumber());
        checkoutPage.setCheckoutBillingPhoneNumber(checkoutBillingInformation.getCheckoutBillingPhoneNumber());
        checkoutPage.setCheckoutBillingEmailAddress(checkoutBillingInformation.getCheckoutBillingEmailAddress());
    }

    @Step
    public void clickPlaceOrderButton() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Step
    public void verifyCheckboxForCreateAccountFunctionality(String passValue) {
        checkoutPage.verifyCheckboxForCreateAccountFunctionality(passValue);
    }

    @Step
    public void addAnOrderNoteForCheckout(String orderNoteText) {
        checkoutPage.addAnOrderNoteForCheckout(orderNoteText);
    }

    @Step
    public void verifyOrderReceivedElementOnPage() {
        checkoutPage.verifyOrderReceivedElementOnPage();
    }

    @Step
    public void verifyOrderHasBeenReceivedMessage() {
        checkoutPage.verifyOrderHasBeenReceivedMessage();
    }

    @Step
    public void verifyIfOrderNoteIsPresentInTheOrderListDetails(String noteText) {
        checkoutPage.verifyIfOrderNoteIsPresentInTheOrderListDetails(noteText);
    }

    @Step
    public void verifyEmailAddressForPlacedOrder(String email) {
        checkoutPage.verifyEmailAddressForPlacedOrder(email);
    }

    @Step
    public void clickShipToDifferentAddressCheckboxButton() {
        checkoutPage.shipToDifferentAddressCheckboxButton();
    }

    @Step
    public void setCheckoutShippingInformation(CheckoutShippingInformation checkoutShippingInformation) {
        checkoutPage.setShippingFirstName(checkoutShippingInformation.getCheckoutShippingFirstName());
        checkoutPage.setShippingLastName(checkoutShippingInformation.getCheckoutShippingLastName());
        checkoutPage.setShippingCompanyName(checkoutShippingInformation.getCheckoutShippingCompanyName());
        checkoutPage.selectShippingCountryName(checkoutShippingInformation.getCheckoutShippingCountryName());
        checkoutPage.setFirstShippingAddress(checkoutShippingInformation.getCheckoutFirstShippingStreetAddressName());
        checkoutPage.setSecondShippingAddress(checkoutShippingInformation.getCheckoutSecondShippingStreetAddressName());
        checkoutPage.setShippingCityName(checkoutShippingInformation.getCheckoutShippingTownCityName());
        checkoutPage.selectCheckoutShippingCountyName(checkoutShippingInformation.getCheckoutShippingCountyName());
        checkoutPage.setShippingPostCodeNumber(checkoutShippingInformation.getCheckoutShippingPostcodeZipNumber());
    }

    @Step
    public void setCheckoutShippingInformationForTextFieldCounty(CheckoutShippingInformation checkoutShippingInformation) {
        checkoutPage.setShippingFirstName(checkoutShippingInformation.getCheckoutShippingFirstName());
        checkoutPage.setShippingLastName(checkoutShippingInformation.getCheckoutShippingLastName());
        checkoutPage.setShippingCompanyName(checkoutShippingInformation.getCheckoutShippingCompanyName());
        checkoutPage.selectShippingCountryName(checkoutShippingInformation.getCheckoutShippingCountryName());
        checkoutPage.setFirstShippingAddress(checkoutShippingInformation.getCheckoutFirstShippingStreetAddressName());
        checkoutPage.setSecondShippingAddress(checkoutShippingInformation.getCheckoutSecondShippingStreetAddressName());
        checkoutPage.setShippingCityName(checkoutShippingInformation.getCheckoutShippingTownCityName());
        checkoutPage.setCheckoutShippingTextFieldCountyName(checkoutShippingInformation.getCheckoutShippingCountyName());
        checkoutPage.setShippingPostCodeNumber(checkoutShippingInformation.getCheckoutShippingPostcodeZipNumber());
    }

    @Step
    public void verifyMessageErrorForEmptyMandatoryFields() {
        checkoutPage.verifyMessageErrorForEmptyMandatoryFields();
    }
}
