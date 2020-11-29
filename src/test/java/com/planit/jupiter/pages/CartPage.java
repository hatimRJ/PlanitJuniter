package com.planit.jupiter.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.planit.jupiter.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class CartPage extends BasePage {


    @FindBy(className = "container-fluid")
    private static WebElement container;

    public static WebDriver webDriver = WebDriverRunner.driver().getWebDriver();

    public boolean open() {
        //Navigate to Jupiter Shop page
        Selenide.open("/#/cart");
        try {
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            waitElementToAppear(container, 3);
            return isElementDisplayed(container);
        } catch (ElementNotVisibleException env) {
            env.printStackTrace();
            return false;
        }
    }

    public boolean verifyCartItems(String product,int expectedQuantity) {
        try {
            WebElement productRow = webDriver.findElement(By.xpath("//tr[@class='cart-item ng-scope']//td[contains(text(),'" + product + "')]/parent::*"));
            return isElementDisplayed(productRow);
        }catch (Exception e){
            throw new  RuntimeException("Unable to find product " + product + " in cart page");
        }
    }
}
