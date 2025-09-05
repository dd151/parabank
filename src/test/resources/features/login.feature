Feature: User Registration

  Background: 
    Given user navigates to landing page

  @Login
  Scenario Outline: Verify successful login
    When user logs in with "<username>" and "<password>"
    Then verify user is navigated to 'Accounts Overview' page

    Examples: 
      | username      | password  |
      | ushnogorom123 | sehun@123 |
