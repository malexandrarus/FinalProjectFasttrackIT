package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CartPage extends BasePage {
    @FindBy(css = ".woocommerce-message .wc-forward")
    private WebElementFacade viewCartButtonFromAddToCartMessageInfo;
    @FindBy(css = ".entry-header .entry-title")
    private WebElementFacade cartElement;
    @FindBy(css = ".cart-control")
    private WebElementFacade cartButton;
    @FindBy(css = ".woocommerce-mini-cart__buttons .wc-forward:first-child")
    private WebElementFacade viewWCartButtonFromMiniCartWidget;
    @FindBy(css = ".woocommerce-cart-form__contents tbody .cart_item")
    private List<WebElementFacade> listOfProductsAddedToCart;
    @FindBy(css = ".actions [name = 'update_cart']")
    private WebElementFacade updateCartButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade messageAfterCartWasUpdated;
    @FindBy(css = ".cart_item .product-remove")
    private List<WebElementFacade> removeButtons;
    @FindBy(css = ".product-remove .remove")
    private WebElementFacade removeButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade removeProductFromCartMessage;
    @FindBy(css = ".cart-empty")
    private WebElementFacade cartEmptyMessage;
    @FindBy(css = ".cart_item .product-subtotal")
    private List<WebElementFacade> priceList;
    @FindBy(css = ".order-total .amount ")
    private WebElementFacade totalPrice;
    @FindBy(css = ".cart-subtotal .amount")
    private WebElementFacade subtotalPrice;
    @FindBy(css = ".shipping .amount")
    private WebElementFacade shippingFeeAmount;
    @FindBy(id = "coupon_code")
    private WebElementFacade couponCodeText;
    @FindBy(css = ".coupon [name = 'apply_coupon']")
    private WebElementFacade applyCouponButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade couponCodeSuccessfullyAppliedMessage;
    @FindBy(css = ".wc-proceed-to-checkout .wc-forward")
    private WebElementFacade proceedToCheckoutButtonFromCart;


    public void clickViewCartButtonFromAddToCartMessageInfo() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", viewCartButtonFromAddToCartMessageInfo);
    }

    public void verifyElementIsVisibleOnPage() {
        cartElement.shouldContainOnlyText("CART");
    }

    public void clickViewYourShoppingCartButton() {
        clickOn(cartButton);
    }

    public boolean addQuantityToProduct(int quantity, String productName) {
        for (WebElementFacade element : listOfProductsAddedToCart) {
            if (productName.equalsIgnoreCase(element.findElement(By.cssSelector(".woocommerce-cart-form__contents .product-name")).getText())) {
                element.findElement(By.cssSelector("[title='Qty']")).clear();
                element.findElement(By.cssSelector("[title='Qty']")).sendKeys(quantity + "");
                updateCartButton.click();
                break;
            }
        }
        return false;
    }

    public void verifyMessageAfterCartWasUpdated() {
        messageAfterCartWasUpdated.shouldContainOnlyText("Cart updated.");
    }

    public void removeProductsFromCart() {
        List<WebElementFacade> copyRemoveButtons = new ArrayList<>(removeButtons);

        for (int i = copyRemoveButtons.size() - 1; i >= 0; i--) {
            waitABit(2000);
            removeButtons.get(i).click();
        }

        waitABit(2000);
        Assert.assertTrue(removeButtons.isEmpty());
        cartEmptyMessage.shouldContainOnlyText("Your cart is currently empty.");
    }

    public void removeSingleProductFromCart() {
        removeButton.click();
    }

    public void verifyRemovedProductFromCartMessage(String productName) {
        removeProductFromCartMessage.shouldContainOnlyText(productName + " removed. Undo?");
    }

    public void verifyAddedProductsArePresentInTheCart() {
        assertTrue(listOfProductsAddedToCart.size() >= 3);
    }

    public double allProductPrices() {
        double totalPrice = 0;
        for (WebElementFacade element : priceList) {
            totalPrice += toDoublePrice(element.getText());
        }
        return totalPrice;
    }

    private double toDoublePrice(String priceNonFormatted) {
        return Double.parseDouble(priceNonFormatted.replace(" lei", "").replace(",", "."));
    }

    public boolean isSubtotalPriceCorrect() {
        return allProductPrices() == toDoublePrice(subtotalPrice.getText());
    }

    public double getSubtotalPriceWithTaxes() {
        String subtotal = subtotalPrice.getText();
        String shipping = "0";
        if (shippingFeeAmount.isPresent()) {
            shipping = shippingFeeAmount.getText();
        }
        return toDoublePrice(subtotal) + toDoublePrice(shipping);
    }

    public boolean isTotalPriceCorrect() {
        return getSubtotalPriceWithTaxes() == toDoublePrice(totalPrice.getText());
    }

    public void setCouponCode(String couponCodeName) {
        typeInto(couponCodeText, couponCodeName);
    }

    public void clickApplyCouponButton() {
        clickOn(applyCouponButton);
    }

    public void verifyCouponCodeSuccessfullyAppliedMessage() {
        couponCodeSuccessfullyAppliedMessage.shouldContainOnlyText("Coupon code applied successfully.");
    }

    public void clickProceedToCheckoutButtonFromCart() {
        clickOn(proceedToCheckoutButtonFromCart);
    }
}
