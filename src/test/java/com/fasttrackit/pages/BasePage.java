package com.fasttrackit.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends PageObject {

    /**
     * This method waits until the element is loaded on page
     *
     * @param webElement the element to be loaded
     * @param text       the text that should contain the element
     */
    protected void waitForElementOnPage(WebElement webElement, String text) {
        waitForCondition().until(
                ExpectedConditions.textToBePresentInElement(webElement, text)
        );
    }
}
