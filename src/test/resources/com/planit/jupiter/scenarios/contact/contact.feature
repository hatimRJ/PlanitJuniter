Feature: Verify UI fields and functionality of Jupiter contact page

    Background:
        Given User is on home page

    Scenario: Validate mandatory fields on contact page
        Given User navigates to contact page
        And User clicks submit button
        When Errors are shown against mandatory fields
        And User populates mandatory fields
        Then Validate field errors disappear

    Scenario: Validate mandatory fields invalid data errors
        Given User navigates to contact page
        When User populates invalid email address
        Then Validate message for invalid email address

    Scenario: Validate successful contact page submission
        Given User navigates to contact page
        And User populates mandatory fields
        When User clicks submit button
        Then Success message is shown to the user






    #@kiwisaverCalc @UX
    #Scenario Outline: Validate information icon and text for all fields on Kiwisaver calculator
    #    Given Information icon is present for "<field>"
    #    When User clicks on information icon for "<field>"
    #    Then Corresponding "<message>" is displayed for "<field>"
    #    Examples:
    #        | field                      | message                                                                                                                                                                                                                                                                                                                                                          |
    #        | Current age                | This calculator has an age limit of 18 to 64 years old.                                                                                                                                                                                                                                                                                                          |
    #        | Employment status          | If you are earning a salary or wage, select ‘Employed’. Your employer contributions will be automatically calculated at a rate of 3% of your before-tax salary or wages. You can also select ‘Self-employed’ or ‘Not employed’ and then enter below (in the Voluntary contributions field), the amount and frequency of any contributions that you wish to make. |
    #        | Current KiwiSaver balance  | If you do not have a KiwiSaver account, then leave this field blank.                                                                                                                                                                                                                                                                                             |
    #        | Voluntary contributions    | If you are 'Self-Employed' or 'Not employed', you can make direct contributions to your KiwiSaver account. If you are 'Employed', you can make voluntary contributions in addition to your regular employee contributions.                                                                                                                                       |
    #        | Risk profile               | The risk profile affects your potential investment returns:                                                                                                                                                                                                                                                                                                      |
    #        | Savings goal at retirement | Enter the amount you would like to have saved when you reach your intended retirement age. If you aren’t sure what this amount is, you can leave it blank or use the Sorted Retirement Planner                                                                                                                                                                   |
#
    #@kiwisaverCalc @functional
    #Scenario Outline: Validate functionality of projected kiwisaver balance
    #    Given User with age "<age>"
    #    And Employment status "<employment status>"  Earning salary "<salary>" per year and contributing "<percentage>" percent to kiwisaver
    #    And Having current kiwisaver balance "<balance>"
    #    And Voluntary contribution "<voluntary contribution>" with frequency "<frequency>"
    #    And With "<risk profile>" risk profile and savings retirement goal of "<savings goal>"
    #    When clicks button to View kiwisaver retirement projections
    #    Then User should be shown Kiwisaver retirement balance amount "<retirement balance>"
    #    Examples:
    #        | age | employment status | salary | percentage | balance | voluntary contribution | frequency | risk profile | savings goal | retirement balance |
    #        | 30  | employed          | 82000  | 4          |         |                        |           | low          |              | 436,365            |
    #        | 45  | self-employed     |        |            | 100000  | 90                     | fortnight | medium       | 290000       | 259,581            |
    #        | 55  | not-employed      |        |            | 140000  | 10                     | year      | high         | 200000       | 197,679            |


