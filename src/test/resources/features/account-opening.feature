@OpenNewAccount
Feature: New Account Opening

  Background:
    Given user navigates to landing page
    And user logs in with "john_smith" and "sehun@123"
    Then verify user is navigated to 'Accounts Overview' page

  Scenario Outline: Verify user is able to new "<Account Type>" account
    When user navigates to "Open New Account" page
    And user opens new account with "<Account Type>" and "<Existing Account>"
    Then verify a new account is created successfully with account number
    Examples:
      | Account Type | Existing Account |
      | CHECKING     |                  |
      | SAVINGS      |                  |

  Scenario Outline: Verify account details after opening new "<Account Type>" account
    When user navigates to "Open New Account" page
    And user opens new account with "<Account Type>" and "<Existing Account>"
    Then verify a new account is created successfully with account number
    And user clicks on the created account number
    Then verify user is navigated to "Account Activity" page
    And verify the account details are displayed:
      | Account Number | Account Type   | Balance | Available |
      |                | <Account Type> | $100.00 | $100.00   |
    Examples:
      | Account Type | Existing Account |
      | CHECKING     |                  |
      | SAVINGS      |                  |

  Scenario Outline: Verify account activity details after opening new "<Account Type>" account
    When user navigates to "Open New Account" page
    And user opens new account with "<Account Type>" and "<Existing Account>"
    Then verify a new account is created successfully with account number
    And user clicks on the created account number
    Then verify user is navigated to "Account Activity" page
    And verify the account activity details are displayed:
      | Date | Transaction             | Debit | Credit  |
      |      | Funds Transfer Received |       | $100.00 |
    Examples:
      | Account Type | Existing Account |
      | CHECKING     |                  |
      | SAVINGS      |                  |

  Scenario Outline: Verify account activity details after opening new "<Account Type>" account
    When user navigates to "Open New Account" page
    And user opens new account with "<Account Type>" and "<Existing Account>"
    Then verify a new account is created successfully with account number
    And user navigates to "Accounts Overview" page
    Then verify created account details are displayed:
      | Account Number | Balance | Available Amount |
      |                | $100.00 | $100.00          |
    Examples:
      | Account Type | Existing Account |
      | CHECKING     |                  |
      | SAVINGS      |                  |


