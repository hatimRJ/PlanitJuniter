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


public class HomePage extends BasePage {

    @FindBy(xpath = "//h1")
    private static WebElement homePageHeading;


    public static WebDriver webDriver = WebDriverRunner.driver().getWebDriver();

    public boolean open() {
        //Navigate to Jupiter Home page
        Selenide.open("/#/home");
        try {
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            waitElementToAppear(homePageHeading, 3);
            return homePageHeading.getText().equals("Jupiter Toys");
        } catch (ElementNotVisibleException env) {
            env.printStackTrace();
            return false;
        }
    }


}
