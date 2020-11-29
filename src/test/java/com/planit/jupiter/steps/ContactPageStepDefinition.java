package com.planit.jupiter.steps;

import com.planit.jupiter.common.BaseTest;
import com.planit.jupiter.pages.ContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;


import java.util.List;

public class ContactPageStepDefinition extends BaseTest {

    ContactPage contactPage;

    public ContactPageStepDefinition(ContactPage contactPage) {
        this.contactPage = contactPage;
    }

    @Given("^User is on contact page$")
    public void userOnContactPage() throws Throwable {
        Assert.assertTrue(contactPage.open(), "Unable to open contact page");
    }

    @Given("User navigates to contact page")
    public void userNavigatesToContactPage() {
        contactPage.navigateToContactPage();
    }

    @And("User clicks submit button")
    public void userClicksSubmitButton() {
        contactPage.clickSubmitButton();
    }

    @When("Errors are shown against mandatory fields")
    public void errorsAreShownAgainstMandatoryFields() {
        Assert.assertEquals(contactPage.getForenameError(), "Forename is required");
        Assert.assertEquals(contactPage.getEmailError(), "Email is required");
        Assert.assertEquals(contactPage.getMessageError(), "Message is required");
    }

    @And("User populates mandatory fields")
    public void userPopulatesMandatoryFields() {
        try {
            contactPage.populateForname("testForname");
            contactPage.populateEmail("testEmail@planit.net.au");
            contactPage.populateMessage("testMessage");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to populate mandatory fields");
        }
    }

    @Then("Validate field errors disappear")
    public void validateFieldErrorsDisappear() {
        Assert.assertTrue(contactPage.mandatoryFieldErrorsNotDispalyed(), "mandatory field errors are displayed");
    }

    @When("User populates invalid email address")
    public void userPopulatesMandatoryFieldsWithInvalidData() {
        contactPage.populateEmail("testemail");
    }

    @Then("Validate message for invalid email address")
    public void validateInvalidDataErrors() {
        Assert.assertEquals(contactPage.getEmailError(), "Please enter a valid email");
    }


    @Then("Success message is shown to the user")
    public void successMessageIsShownToTheUser() {
        Assert.assertTrue(contactPage.returnSubmissionMessage().contains("we appreciate your feedback."));
    }
}