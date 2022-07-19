package com.fasttrackit.features.search;

import com.fasttrackit.model.CheckoutBillingInformation;
import com.fasttrackit.model.CheckoutShippingInformation;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutAsGuestTest() {
        loginSteps.navigateToHomepage();
        // add first product
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();

        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();
        checkoutSteps.setCheckoutBillingInformation(buildBillingInformation("Romania", "Cluj", "Cluj-Napoca"));
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifyOrderReceivedElementOnPage();
    }

    @Test
    public void checkoutWithoutFillingTheMandatoryFields() {
        loginSteps.navigateToHomepage();
        // add first product
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();

        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();
        checkoutSteps.setCheckoutBillingInformationForTextFieldCounty(buildBillingInformationForEmptyMandatoryFields("Select a country…", "", ""));
        checkoutSteps.clickShipToDifferentAddressCheckboxButton();
        checkoutSteps.setCheckoutShippingInformationForTextFieldCounty(buildCheckoutShippingInformationForEmptyMandatoryFields("Select a country…", "", ""));
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifyMessageErrorForEmptyMandatoryFields();
    }

    @Test
    public void checkoutProcessWithAlreadyLoggedUserTest() {
        loginSteps.doLogin();
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifyOrderHasBeenReceivedMessage();
    }

    @Test
    public void checkoutAsGuestAndUsingCreateAccountOptionFromTheCheckoutDetailsPageTest() {
        loginSteps.navigateToHomepage();
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();

        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        checkoutSteps.setCheckoutBillingInformation(buildBillingInformationWithCustomEmail("Romania", "Cluj", "Cluj-Napoca", email));
        checkoutSteps.verifyCheckboxForCreateAccountFunctionality("Poligon12@3");
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifyOrderHasBeenReceivedMessage();
        checkoutSteps.verifyEmailAddressForPlacedOrder(email);
    }

    @Test
    public void checkoutAddAnOrderNoteWithAlreadyLoggedUserTest() {
        loginSteps.navigateToHomepage();
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();
        checkoutSteps.setCheckoutBillingInformation(buildBillingInformation("Romania", "Cluj", "Cluj-Napoca"));

        String noteText = "Testing purposes!";
        checkoutSteps.addAnOrderNoteForCheckout(noteText);
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifyIfOrderNoteIsPresentInTheOrderListDetails(noteText);
    }

    @Test
    public void checkoutTestWithDifferentValuesThenDefaultValuesForCountryAndCountyTest() {
        loginSteps.navigateToHomepage();
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();
        checkoutSteps.setCheckoutBillingInformationForTextFieldCounty(buildBillingInformation("Qatar", "Doha", "Dukhan"));
        checkoutSteps.clickPlaceOrderButton();
    }

    @Test
    public void checkoutAsGuestWithBothBillingAndShippingInformationFilledTest() {
        loginSteps.navigateToHomepage();
        // add first product
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();

        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();
        checkoutSteps.setCheckoutBillingInformation(buildBillingInformation("Romania", "Cluj", "Cluj-Napoca"));
        checkoutSteps.clickShipToDifferentAddressCheckboxButton();
        checkoutSteps.setCheckoutShippingInformation(buildCheckoutShippingInformation("Romania", "Cluj", "Cluj-Napoca"));
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifyOrderHasBeenReceivedMessage();
    }

    @Test
    public void checkoutTestWithDifferentValuesThenDefaultValuesForCountryAndCountyForShippingOptionTest() {
        loginSteps.navigateToHomepage();
        searchSteps.searchForProduct("Album");
        shopSteps.addProductToCart();

        // add second product
        searchSteps.searchForProduct("Beanie with Logo");
        shopSteps.addProductToCart();

        // add third product
        searchSteps.searchForProduct("Hoodie with Zipper");
        shopSteps.addProductToCart();
        cartSteps.clickViewYourShoppingCartButton();
        cartSteps.verifyAddedProductsArePresentInTheCart();
        cartSteps.clickProceedToCheckoutButtonFromCart();
        checkoutSteps.setCheckoutBillingInformationForTextFieldCounty(buildBillingInformation("Qatar", "Doha", "Dukhan"));
        checkoutSteps.clickShipToDifferentAddressCheckboxButton();
        checkoutSteps.setCheckoutShippingInformationForTextFieldCounty(buildCheckoutShippingInformation("Qatar", "Doha", "Dukhan"));
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifyOrderHasBeenReceivedMessage();
    }

    private CheckoutBillingInformation buildBillingInformationWithCustomEmail(String countryName, String countyName, String townName, String email) {
        CheckoutBillingInformation checkoutBillingInformation = new CheckoutBillingInformation();
        checkoutBillingInformation = buildBillingInformation(countryName, countyName, townName);
        checkoutBillingInformation.setCheckoutBillingEmailAddress(email);

        return checkoutBillingInformation;
    }

    private CheckoutBillingInformation buildBillingInformation(String countryName, String countyName, String townName) {
        CheckoutBillingInformation checkoutBillingInformation = new CheckoutBillingInformation();
        checkoutBillingInformation.setCheckoutBillingFirstName("Alexandra");
        checkoutBillingInformation.setCheckoutBillingLastName("Rus");
        checkoutBillingInformation.setCheckoutBillingCompanyName("Tralala");
        checkoutBillingInformation.setCheckoutBillingCountryName(countryName);
        checkoutBillingInformation.setCheckoutFirstBillingStreetAddressName("Buna-Ziua");
        checkoutBillingInformation.setCheckoutSecondBillingStreetAddressName("Nr. 7");
        checkoutBillingInformation.setCheckoutBillingTownCityName(townName);
        checkoutBillingInformation.setCheckoutBillingCountyName(countyName);
        checkoutBillingInformation.setCheckoutBillingPostcodeZipNumber("123456");
        checkoutBillingInformation.setCheckoutBillingPhoneNumber("1234567891");
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        checkoutBillingInformation.setCheckoutBillingEmailAddress(email);

        return checkoutBillingInformation;
    }

    private CheckoutShippingInformation buildCheckoutShippingInformation(String shippingCountryName, String shippingCountyName, String shippingTownName) {
        CheckoutShippingInformation checkoutShippingInformation = new CheckoutShippingInformation();
        checkoutShippingInformation.setCheckoutShippingFirstName("Alexandra");
        checkoutShippingInformation.setCheckoutShippingLastName("Rus");
        checkoutShippingInformation.setCheckoutShippingCompanyName("Tralala");
        checkoutShippingInformation.setCheckoutShippingCountryName(shippingCountryName);
        checkoutShippingInformation.setCheckoutFirstShippingStreetAddressName("Buna-Ziua");
        checkoutShippingInformation.setCheckoutSecondShippingStreetAddressName("Nr. 7");
        checkoutShippingInformation.setCheckoutShippingTownCityName(shippingTownName);
        checkoutShippingInformation.setCheckoutShippingCountyName(shippingCountyName);
        checkoutShippingInformation.setCheckoutShippingPostcodeZipNumber("123456");

        return checkoutShippingInformation;
    }

    private CheckoutBillingInformation buildBillingInformationForEmptyMandatoryFields(String countryName, String countyName, String townName) {
        CheckoutBillingInformation checkoutBillingInformation = new CheckoutBillingInformation();
        checkoutBillingInformation.setCheckoutBillingFirstName("");
        checkoutBillingInformation.setCheckoutBillingLastName("");
        checkoutBillingInformation.setCheckoutBillingCompanyName("");
        checkoutBillingInformation.setCheckoutBillingCountryName(countryName);
        checkoutBillingInformation.setCheckoutFirstBillingStreetAddressName("");
        checkoutBillingInformation.setCheckoutSecondBillingStreetAddressName("");
        checkoutBillingInformation.setCheckoutBillingTownCityName(townName);
        checkoutBillingInformation.setCheckoutBillingCountyName(countyName);
        checkoutBillingInformation.setCheckoutBillingPostcodeZipNumber("");
        checkoutBillingInformation.setCheckoutBillingPhoneNumber("");
        checkoutBillingInformation.setCheckoutBillingEmailAddress("");

        return checkoutBillingInformation;
    }

    private CheckoutShippingInformation buildCheckoutShippingInformationForEmptyMandatoryFields(String shippingCountryName, String shippingCountyName, String shippingTownName) {
        CheckoutShippingInformation checkoutShippingInformation = new CheckoutShippingInformation();
        checkoutShippingInformation.setCheckoutShippingFirstName("");
        checkoutShippingInformation.setCheckoutShippingLastName("");
        checkoutShippingInformation.setCheckoutShippingCompanyName("");
        checkoutShippingInformation.setCheckoutShippingCountryName(shippingCountryName);
        checkoutShippingInformation.setCheckoutFirstShippingStreetAddressName("");
        checkoutShippingInformation.setCheckoutSecondShippingStreetAddressName("");
        checkoutShippingInformation.setCheckoutShippingTownCityName(shippingTownName);
        checkoutShippingInformation.setCheckoutShippingCountyName(shippingCountyName);
        checkoutShippingInformation.setCheckoutShippingPostcodeZipNumber("");

        return checkoutShippingInformation;
    }
}
