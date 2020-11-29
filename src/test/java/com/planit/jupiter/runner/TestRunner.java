package com.planit.jupiter.runner;

import com.codeborne.selenide.Selenide;
import com.planit.jupiter.common.BaseTest;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions(
        strict = true,
        glue = {"com.planit.jupiter"},
        plugin = {
                "pretty",
                "summary",
                "html:build/cucumber-reports/cucumber-pretty",
                "json:build/cucumber-reports/CucumberTestReport.json",
                "rerun:build/cucumber-reports/rerun.txt"
        },
        features = {"src/test/resources/com/planit/jupiter/scenarios"}
)
public class TestRunner extends BaseTest {

    @BeforeClass
    public void BeforeClass() {
        Selenide.open();
    }

    @AfterClass
    public void AfterClass() {

    }

    @SuppressWarnings({"groupsTestNG"})
    @Test(
            groups = "cucumber",
            dataProvider = "scenarios",
            description = "Planit Jupiter Tests")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        super.runScenario(pickleWrapper, featureWrapper);
    }
}
