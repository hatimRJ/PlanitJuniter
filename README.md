# Planit Jupiter Test Automation

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [**Environment**](#environment)
- [**Frameworks/Libraries**](#frameworkslibraries)
- [**How To Use**](#how-to-use)
  - [**Clone Repository**](#clone-repository)
  - [**Configuration Files**](#configuration-files)
  - [**Run Tests With Gradle**](#run-tests-with-gradle)
    - [**Perform On Browsers**](#perform-on-browsers)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## **Environment**
> **IDE**: <em>IntelliJ IDEA 2019.3.1 (Community Edition)</em><br/>
> **Java**: <em>1.8.0_211</em><br/>
> **Gradle**: <em>6.1.1</em><br/>

## **Frameworks/Libraries**
> **Selenide**: <em>5.6.1 - Web Driver</em><br/>
> **TestNG**: <em>7.1.0 - Testing Framework</em><br/>
> **Cucumber**: <em>5.0.0 - Behavior Driven Development (BDD) Tool</em><br/>
> **Cucumber Reporting**: <em>0.1.16 - Generating Reports From CucumberTestReport.json For Gradle</em><br/>


## **How To Use**
### **Clone Repository**
> `$ git clone https://github.com/hatimRJ/WestpacKiwisaver.git`

### **Configuration Files**
You can change values for your case.

1. [log4j.properties](src/test/resources/log4j.properties)<br/>
    > Configuring log4j involves assigning the Level, defining Appender, and specifying Layout objects in a configuration file.
2. [selenide.properties](src/test/resources/selenide.properties)<br/>
    > Configuration settings for Selenide default browser. Settings can be set either via system property or programmatically.

### **Run Tests With Gradle**
> `./gradlew clean test`<br/>

#### **Perform On Browsers**
- chrome
- firefox
- ie
- edge

Able to select browser by passing system property `selenide.browser`<br/>
> `./gradlew clean test -Dselenide.browser=firefox`



