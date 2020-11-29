Feature: Verify UI fields and functionality of Jupiter contact page

    Background:
        Given User is on home page

    @ContactsTests
    Scenario: Validate mandatory fields on contact page
        Given User navigates to contact page
        And User clicks submit button
        When Errors are shown against mandatory fields
        And User populates mandatory fields
        Then Validate field errors disappear

    @ContactsTests
    Scenario: Validate mandatory fields invalid data errors
        Given User navigates to contact page
        When User populates invalid email address
        Then Validate message for invalid email address

    @ContactsTests
    Scenario: Validate successful contact page submission
        Given User navigates to contact page
        And User populates mandatory fields
        When User clicks submit button
        Then Success message is shown to the user


