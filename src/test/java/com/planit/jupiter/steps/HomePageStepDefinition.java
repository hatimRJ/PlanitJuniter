package com.planit.jupiter.steps;

import com.planit.jupiter.common.BaseTest;
import com.planit.jupiter.pages.ContactPage;
import com.planit.jupiter.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;

public class HomePageStepDefinition extends BaseTest {

    HomePage homePage;

    public HomePageStepDefinition(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("^User is on home page$")
    public void userOnHomePage() throws Throwable {
        Assert.assertTrue(homePage.open(), "Unable to open home page");

    }
}