package com.planit.jupiter.steps;

import com.planit.jupiter.common.BaseTest;
import com.planit.jupiter.pages.CartPage;
import com.planit.jupiter.pages.ContactPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPageStepDefinition extends BaseTest {

    CartPage cartPage;

    public CartPageStepDefinition(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @Given("^User is on cart page$")
    public void userOnCartPage() throws Throwable {
        Assert.assertTrue(cartPage.open(), "Unable to open cart page");

    }

    @When("User navigates to cart page")
    public void userNavigatesToCartPage() {
    }

    @Then("Verify cart has the purchased products")
    public void verifyCartHasThePurchasedProducts(DataTable table) {
        Map<String, String> productMap = new HashMap<>();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            Assert.assertTrue(cartPage.verifyCartItems(columns.get("product"), Integer.parseInt(columns.get("quantity"))));
        }
    }
}