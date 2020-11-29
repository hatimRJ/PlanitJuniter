package com.planit.jupiter.steps;

import com.planit.jupiter.common.BaseTest;
import com.planit.jupiter.pages.ContactPage;
import com.planit.jupiter.pages.ShopPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ShopPageStepDefinition extends BaseTest {

    ShopPage shopPage;

    public ShopPageStepDefinition(ShopPage shopPage) {
        this.shopPage = shopPage;
    }

    @Given("^User is on shop page$")
    public void userOnShopPage() throws Throwable {
        Assert.assertTrue(shopPage.open(), "Unable to open shop page");

    }

    @Given("User clicks to buy products")
    public void userClicksToBuyProducts(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            for (int i = 0; i < Integer.parseInt(columns.get("quantity")); i++) {
                shopPage.purchaseItem(columns.get("product"));
            }
        }
    }

    @When("User clicks on cart page")
    public void userClicksOnCartPage() {
        shopPage.navigateToCartPage();
    }
}