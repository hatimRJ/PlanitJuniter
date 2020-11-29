Feature: Verify Jupiter Shopping cart functionality

    Background:
        Given User is on shop page

    Scenario: Shop items and validate cart
        Given User clicks to buy products
            | quantity | product      |
            | 2        | Funny Cow    |
            | 1        | Fluffy Bunny |
        When User clicks on cart page
        Then Verify cart has the purchased products
            | quantity | product      |
            | 2        | Funny Cow    |
            | 1        | Fluffy Bunny |

