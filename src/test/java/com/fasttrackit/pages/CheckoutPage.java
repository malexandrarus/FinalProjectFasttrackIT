package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

import static org.junit.Assert.*;

public class CheckoutPage extends BasePage {

    @FindBy(id = "billing_first_name")
    private WebElementFacade checkoutBillingFirstName;
    @FindBy(id = "billing_last_name")
    private WebElementFacade checkoutBillingLastName;
    @FindBy(id = "billing_company")
    private WebElementFacade checkoutBillingCompanyName;
    @FindBy(css = "#billing_country_field .select2-selection__arrow")
    private WebElementFacade expandCountryList;
    @FindBy(css = "#billing_country_field .select2-selection__rendered")
    private WebElementFacade defaultCountryName;
    @FindBy(id = "billing_address_1")
    private WebElementFacade checkoutFirstBillingStreetAddressName;
    @FindBy(id = "billing_address_2")
    private WebElementFacade checkoutSecondBillingStreetAddressName;
    @FindBy(id = "billing_city")
    private WebElementFacade checkoutBillingCityName;
    @FindBy(css = "#billing_state_field #billing_state")
    private WebElementFacade checkoutBillingTextFieldCountyName;
    @FindBy(css = "#billing_state_field .select2-selection__rendered")
    private WebElementFacade defaultCountyName;
    @FindBy(css = "#billing_state_field .select2-selection__arrow")
    private WebElementFacade expandCountyList;
    @FindBy(id = "billing_postcode")
    private WebElementFacade checkoutBillingPostCodeNumber;
    @FindBy(id = "billing_phone")
    private WebElementFacade checkoutBillingPhoneNumber;
    @FindBy(id = "billing_email")
    private WebElementFacade checkoutBillingEmailAddress;
    @FindBy(id = "createaccount")
    private WebElementFacade checkoutBillingCreateAccountCheckboxButton;
    @FindBy(id = "account_password")
    private WebElementFacade checkoutBillingCreateAccountPass;
    @FindBy(id = "order_comments")
    private WebElementFacade checkoutOrderNote;
    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;
    @FindBy(css = ".woocommerce-error")
    private List<WebElementFacade> billingRequiredDataMessageErrorList;

    @FindBy(id = "ship-to-different-address-checkbox")
    private WebElementFacade shipToDifferentAddressCheckboxButton;
    @FindBy(id = "shipping_first_name")
    private WebElementFacade shippingFirstName;
    @FindBy(id = "shipping_last_name")
    private WebElementFacade shippingLastName;
    @FindBy(id = "shipping_company")
    private WebElementFacade shippingCompanyName;
    @FindBy(css = "#shipping_country_field .select2-selection__rendered")
    private WebElementFacade defaultShippingCountryName;
    @FindBy(css = "#shipping_country_field .select2-selection__arrow")
    private WebElementFacade expandShippingCountryList;
    @FindBy(id = "shipping_address_1")
    private WebElementFacade firstShippingAddress;
    @FindBy(id = "shipping_address_2")
    private WebElementFacade secondShippingAddress;
    @FindBy(id = "shipping_city")
    private WebElementFacade shippingCityName;
    @FindBy(css = "#shipping_state_field .select2-selection__rendered")
    private WebElementFacade defaultShippingCountyName;
    @FindBy(css = "#shipping_state_field .select2-selection__arrow")
    private WebElementFacade expandShippingCountyList;
    @FindBy(css = "#shipping_state_field #shipping_state")
    private WebElementFacade checkoutShippingTextFieldCountyName;
    @FindBy(id = "shipping_postcode")
    private WebElementFacade shippingPostCodeNumber;

    @FindBy(css = ".order_details tfoot tr")
    private List<WebElementFacade> orderDetailsListTable;
    @FindBy(css = ".woocommerce-order-overview__email strong")
    private WebElementFacade verifyEmailAddressForOrderReceived;
    @FindBy(css = ".entry-header .entry-title")
    private WebElementFacade orderReceivedElement;
    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElementFacade orderHasBeenReceivedMessage;
    @FindBy(css = ".woocommerce-order-overview__email strong")
    private WebElementFacade orderConfirmationEmail;
    @FindBy(css = ".woocommerce-error li:last-child")
    private WebElementFacade verifyErrorForEmptyMandatoryFields;

    /*
    Logic for Checkout Billing information
     */
    public void setCheckoutBillingFirstName(String firstName) {
        typeInto(checkoutBillingFirstName, firstName);
    }

    public void setCheckoutBillingLastName(String lastName) {
        typeInto(checkoutBillingLastName, lastName);
    }

    public void setCheckoutBillingCompanyName(String companyName) {
        typeInto(checkoutBillingCompanyName, companyName);
    }

    public void selectCheckoutBillingCountryName(String countryName) {
        if (defaultCountryName.getText().equals(countryName)) {
            clickOn(checkoutFirstBillingStreetAddressName);
        } else {
            clickOn(expandCountryList);
            List<WebElementFacade> checkoutBillingCountryNameList = findAll(By.cssSelector("#select2-billing_country-results li"));

            for (WebElementFacade countryNameElement : checkoutBillingCountryNameList) {
                if (countryNameElement.getText().equals(countryName)) {
                    countryNameElement.click();
                    break;
                }
            }
        }
    }

    public void setFirstCheckoutBillingStreetAddressName(String firstAddressValue) {
        typeInto(checkoutFirstBillingStreetAddressName, firstAddressValue);
    }

    public void setSecondCheckoutBillingStreetAddressName(String secondAddressValue) {
        typeInto(checkoutSecondBillingStreetAddressName, secondAddressValue);
    }

    public void setCheckoutBillingCityName(String cityValue) {
        typeInto(checkoutBillingCityName, cityValue);
    }

    public void setCheckoutBillingTextFieldCountyName(String countyValue) {
        typeInto(checkoutBillingTextFieldCountyName, countyValue);
    }

    public void selectCheckoutBillingCountyName(String countyName) {
        if (defaultCountyName.getText().equals(countyName)) {
            clickOn(checkoutBillingPostCodeNumber);
        } else {
            clickOn(expandCountyList);
            List<WebElementFacade> checkoutBillingCountyNameList = findAll(By.cssSelector("#select2-billing_state-results li"));

            for (WebElementFacade countyNameElement : checkoutBillingCountyNameList) {
                if (countyNameElement.getText().equals(countyName)) {
                    countyNameElement.click();
                    break;
                }
            }
        }
    }

    public void setCheckoutBillingPostCodeNumber(String postCodeValue) {
        typeInto(checkoutBillingPostCodeNumber, postCodeValue);
    }

    public void setCheckoutBillingPhoneNumber(String phoneNumberValue) {
        typeInto(checkoutBillingPhoneNumber, phoneNumberValue);
    }

    public void setCheckoutBillingEmailAddress(String emailAddressValue) {
        typeInto(checkoutBillingEmailAddress, emailAddressValue);
    }

    public void verifyCheckboxForCreateAccountFunctionality(String passValue) {
        if (checkoutBillingCreateAccountCheckboxButton.isSelected()) {
            assertTrue(checkoutBillingCreateAccountPass.isDisplayed());
            typeInto(checkoutBillingCreateAccountPass, passValue);
        } else {
            checkoutBillingCreateAccountCheckboxButton.click();
            assertTrue(checkoutBillingCreateAccountPass.isDisplayed());
            waitFor(checkoutBillingCreateAccountPass);
            typeInto(checkoutBillingCreateAccountPass, passValue);
        }
    }

    public void clickPlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public void verifyOrderReceivedElementOnPage() {
        waitForElementOnPage(orderReceivedElement, "ORDER RECEIVED");
        shouldContainAllText("ORDER RECEIVED");
    }

    public void verifyOrderHasBeenReceivedMessage() {
        waitForElementOnPage(orderHasBeenReceivedMessage, "Thank you. Your order has been received.");
        shouldContainAllText("Thank you. Your order has been received.");
    }

    public void addAnOrderNoteForCheckout(String orderNoteText) {
        typeInto(checkoutOrderNote, orderNoteText);
    }

    public void verifyIfOrderNoteIsPresentInTheOrderListDetails(String noteText) {
        for (WebElementFacade orderNoteElement : orderDetailsListTable) {
            if (orderNoteElement.getText().equals(noteText)) {
                assertTrue(orderNoteElement.isVisible());
            }
            break;
        }
    }

    public void verifyEmailAddressForPlacedOrder(String email) {
        assertEquals(email, orderConfirmationEmail.getText());
    }

    /*
    Logic for Checkout Shipping information
     */
    public void shipToDifferentAddressCheckboxButton() {
        if (!shipToDifferentAddressCheckboxButton.isSelected()) {
            assertFalse(shipToDifferentAddressCheckboxButton.isSelected());
            shipToDifferentAddressCheckboxButton.click();
        } else {
            assertTrue(shipToDifferentAddressCheckboxButton.isDisplayed());
        }
    }

    public void setShippingFirstName(String firstName) {
        typeInto(shippingFirstName, firstName);
    }

    public void setShippingLastName(String lastName) {
        typeInto(shippingLastName, lastName);
    }

    public void setShippingCompanyName(String companyName) {
        typeInto(shippingCompanyName, companyName);
    }

    public void selectShippingCountryName(String countryName) {
        if (defaultShippingCountryName.getText().equals(countryName)) {
            clickOn(firstShippingAddress);
        } else {
            clickOn(expandShippingCountryList);
            List<WebElementFacade> checkoutShippingCountryNameList = findAll(By.cssSelector("#select2-shipping_country-results li"));

            for (WebElementFacade countryNameElement : checkoutShippingCountryNameList) {
                if (countryNameElement.getText().equals(countryName)) {
                    countryNameElement.click();
                    break;
                }
            }
        }
    }

    public void setFirstShippingAddress(String firstAddressValue) {
        typeInto(firstShippingAddress, firstAddressValue);
    }

    public void setSecondShippingAddress(String secondAddressValue) {
        typeInto(secondShippingAddress, secondAddressValue);
    }

    public void setShippingCityName(String cityName) {
        typeInto(shippingCityName, cityName);
    }

    public void selectCheckoutShippingCountyName(String countyName) {
        if (defaultShippingCountyName.getText().equals(countyName)) {
            clickOn(shippingPostCodeNumber);
        } else {
            clickOn(expandShippingCountyList);
            List<WebElementFacade> checkoutShippingCountyNameList = findAll(By.cssSelector("#select2-shipping_state-results li"));

            for (WebElementFacade countyNameElement : checkoutShippingCountyNameList) {
                if (countyNameElement.getText().equals(countyName)) {
                    countyNameElement.click();
                    break;
                }
            }
        }
    }

    public void setCheckoutShippingTextFieldCountyName(String countyValue) {
        typeInto(checkoutShippingTextFieldCountyName, countyValue);
    }

    public void setShippingPostCodeNumber(String postCodeValue) {
        typeInto(shippingPostCodeNumber, postCodeValue);
    }

    public void verifyMessageErrorForEmptyMandatoryFields() {
        verifyErrorForEmptyMandatoryFields.shouldContainOnlyText("Please enter an address to continue.");
    }
}
