package com.fasttrackit.pages;

import io.cucumber.messages.internal.com.google.common.primitives.Doubles;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ShopPage extends BasePage {

    @FindBy(css = ".products .item")
    private List<WebElementFacade> productShopList;
    @FindBy(css = "[name = 'add-to-cart']")
    private WebElementFacade addToCartButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade addProductToCartMessage;
    @FindBy(css = ".product_type_variable")
    private WebElementFacade selectOptionsButton;
    @FindBy(id = "pa_color")
    private WebElementFacade selectColorFromDropdown;
    @FindBy(id = "logo")
    private WebElementFacade selectLogoFromDropdown;
    @FindBy(css = ".orderby")
    private WebElementFacade sortBySelection;
    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButtonFromProductPage;
    @FindBy(css = "[rel = bookmark]")
    private WebElementFacade editIconForProductAfterSearch;

    public static final String SINGLE_PRODUCT_ADDED_TO_CART_MESSAGE = "has been added to your cart";
    public static final String MULTIPLE_PRODUCTS_ADDED_TO_CART_MESSAGE = "have been added to your cart";

    public void selectProductFromTheShopList() {
        if (!productShopList.isEmpty()) {
            WebElementFacade firstProduct = productShopList.get(0);
            firstProduct.click();
        }
    }

    public void addProductToCart() {
        clickOn(addToCartButton);

    }

    public boolean verifyMessageAfterProductWasAddedToCart(Integer quantity) {
        if (quantity == 1) {
            return addProductToCartMessage.containsText(SINGLE_PRODUCT_ADDED_TO_CART_MESSAGE);
        } else {
            return addProductToCartMessage.containsText(String.valueOf(quantity).concat(" × ")) &&
                    addProductToCartMessage.containsText(MULTIPLE_PRODUCTS_ADDED_TO_CART_MESSAGE);
        }


    }

    public boolean verifyProductIsPresentInTheList(String text) {
        for (WebElementFacade elementFacade : productShopList) {
            if (elementFacade.getText().equals(text)) {
                elementFacade.click();
            }
            break;
        }
        return false;
    }

    public void clickOnSelectOptionsButton() {
        clickOn(selectOptionsButton);
    }

    public void selectColorFromDropdown(String colorValue) {
        selectFromDropdown(selectColorFromDropdown, colorValue);
    }

    public void selectLogoFromDropdown(String logoValue) {
        selectFromDropdown(selectLogoFromDropdown, logoValue);
    }

    public void clickAddToCartButtonFromProductPage() {
        clickOn(addToCartButtonFromProductPage);
    }

    public void setSortByDropdown(String value) {
        sortBySelection.selectByVisibleText(value);
    }

    private double priceFromProduct(WebElementFacade element) {
        String priceString = element.find(By.cssSelector(".p-info .price .amount:nth-child(1)")).getText();
        String priceStringWithPoint = priceString.replace(",", ".");
        String priceStringWithoutLei = priceStringWithPoint.replace("lei", "");

        return Double.parseDouble(priceStringWithoutLei);
    }

    private double sellingPriceFromProductWithMultiplePrices(WebElementFacade element) {
        String priceString = element.find(By.cssSelector(".p-info .price ins")).getText();
        String priceStringWithPoint = priceString.replace(",", ".");
        String priceStringWithoutLei = priceStringWithPoint.replace("lei", "");

        return Double.parseDouble(priceStringWithoutLei);
    }

    public boolean isSortByPriceDescending() {
        double firstPrice = priceFromProduct(productShopList.get(0));
        double lastPrice = sellingPriceFromProductWithMultiplePrices(productShopList.get(productShopList.size() - 1));

        return Doubles.compare(firstPrice, lastPrice) > 0;
    }

    public boolean selectProductFromListUsingAKeyword(String productName) {
        for (WebElementFacade product : productShopList) {
            if (product.findElement(By.cssSelector(".product-details .title")).getText().equalsIgnoreCase(productName)) {
                product.findElement(By.cssSelector(".thumb .wp-post-image")).click();
                break;
            }
        }
        return false;
    }

    public void clickEditIconForProductAfterSearch() {
        clickOn(editIconForProductAfterSearch);
    }
}
