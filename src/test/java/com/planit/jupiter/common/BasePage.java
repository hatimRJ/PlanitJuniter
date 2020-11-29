package com.planit.jupiter.common;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.SelenidePageFactory;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

public abstract class BasePage extends SelenidePageFactory {

    protected BasePage() {
        this.page(WebDriverRunner.driver(), this);
    }

    @FindBy(id = "nav-home")
    private static WebElement navigateToHome;

    @FindBy(id = "nav-shop")
    private static WebElement navigateToShop;

    @FindBy(id = "nav-contact")
    private static WebElement navigateToContact;

    @FindBy(id = "nav-cart")
    private static WebElement navigateToCart;

    //Wait for an element to be displayed within provided attempts
    protected void waitElementToAppear(WebElement webElement, int maxAttempts) {
        while (!isElementDisplayed(webElement) && maxAttempts > 0) {
            maxAttempts--;
        }
        if (!isElementDisplayed(webElement)) {
            throw new ElementNotVisibleException("Element " + webElement + " is not displayed");
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void populateInputField(WebElement inputField, String value) {
        try {
            waitElementToAppear(inputField, 10);
            inputField.sendKeys(value);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


    public void clickElement(WebElement element, String elementName) {
        waitElementToAppear(element, 3);
        if (isElementDisplayed(element)) {
            element.click();
        } else {
            throw new RuntimeException("Unable to click " + elementName);
        }
    }

    public void navigateToHomePage() {
        clickElement(navigateToHome, "Home link in title bar");
    }

    public void navigateToShopPage() {
        clickElement(navigateToShop, "Shop link in title bar");
    }

    public void navigateToContactPage() {
        clickElement(navigateToContact, "Contact link in title bar");
    }

    public void navigateToCartPage() {
        clickElement(navigateToCart, "Cart link in title bar");
    }
}