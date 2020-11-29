package com.planit.jupiter.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.planit.jupiter.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ContactPage extends BasePage {


    @FindBy(id = "forename")
    private static WebElement forename;

    @FindBy(id = "surname")
    private static WebElement surname;

    @FindBy(id = "email")
    private static WebElement email;

    @FindBy(id = "telephone")
    private static WebElement telephone;

    @FindBy(id = "message")
    private static WebElement message;

    @FindBy(id = "forename-err")
    private static WebElement forenameError;

    @FindBy(id = "email-err")
    private static WebElement emailError;

    @FindBy(id = "message-err")
    private static WebElement messageError;

    @FindBy(xpath = "//*[@class='btn-contact btn btn-primary']")
    private static WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private static WebElement submissionSuccessMessage;

    public static WebDriver webDriver = WebDriverRunner.driver().getWebDriver();

    public boolean open() {
        //Navigate to Jupiter Contact page
        Selenide.open("/#/contact");
        try {
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            waitElementToAppear(forename, 3);
            return isElementDisplayed(forename);
        } catch (ElementNotVisibleException env) {
            env.printStackTrace();
            return false;
        }
    }

    public void clickSubmitButton() {
        clickElement(submitButton, "Contact page submit button");
    }

    private String returnMessage(WebElement element) {
        if (isElementDisplayed(element)) {
            return element.getText();
        } else return null;
    }

    public String getForenameError() {
        return returnMessage(forenameError);
    }

    public String getEmailError() {
        return returnMessage(emailError);
    }

    public String getMessageError() {
        return returnMessage(messageError);
    }

    private void populateField(WebElement element, String value) {
        try {
            waitElementToAppear(element, 3);
            if (isElementDisplayed(element)) {
                element.sendKeys(value);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unbale to populate field " + element.getAttribute("name") + " with value " + value);
        }
    }

    public void populateForname(String value) {
        populateField(forename, value);
    }

    public void populateEmail(String value) {
        populateField(email, value);
    }

    public void populateMessage(String value) {
        populateField(message, value);
    }

    public List<WebElement> getMandatoryFields() {
        List<WebElement> mandatoryElements = new ArrayList<>();
        List<WebElement> fieldGroups = webDriver.findElements(By.xpath("//div[contains(@id,'group') or contains(@class,'group')]"));
        for (WebElement field : fieldGroups) {
            if (field.findElements(By.className("req")).size() > 0) {
                mandatoryElements.add(field);
            }
        }
        return mandatoryElements;
    }

    public boolean mandatoryFieldErrorsNotDispalyed() {
        try {
            if (forenameError.isDisplayed() || emailError.isDisplayed() || messageError.isDisplayed()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String returnSubmissionMessage() {
        waitElementToAppear(submissionSuccessMessage, 10);
        if (isElementDisplayed(submissionSuccessMessage)) {
            return submissionSuccessMessage.getText();
        } else return null;
    }
}
