package com.planit.jupiter.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.planit.jupiter.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class ShopPage extends BasePage {


    @FindBy(id = "product-1")
    private static WebElement product1;


    public static WebDriver webDriver = WebDriverRunner.driver().getWebDriver();

    public boolean open() {
        //Navigate to Jupiter Shop page
        Selenide.open("/#/shop");
        try {
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            waitElementToAppear(product1, 3);
            return isElementDisplayed(product1);
        } catch (ElementNotVisibleException env) {
            env.printStackTrace();
            return false;
        }
    }

    public void purchaseItem(String itemName) {
        try {
            WebElement item = webDriver.findElement(By.xpath("//*[contains(text(),'" + itemName + "')]/parent::*//a[@class='btn btn-success']"));
            clickElement(item, itemName + " buy button");
        } catch (Exception e) {
            throw new RuntimeException("Unable to buy item " + itemName);
        }
    }
}
