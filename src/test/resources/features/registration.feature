Feature: User Registration

  Background: 
    Given user navigates to landing page

  @Registration
  Scenario: Verify user navigation to Registration page
    When user clicks on 'Register' link
    Then verify user is navigated to "Registration" page
    And verify the registration form is displayed with fields:
      | First Name |
      | Last Name  |
      | Address    |
      | City       |
      | State      |
      | Zip Code   |
      | Phone #    |
      | SSN        |
      | Username   |
      | Password   |
      | Confirm    |

  @Registration
  Scenario: Verify suggessful user registration in Registration Page
    When user clicks on 'Register' link
    Then verify user is navigated to "Registration" page
    And user enters registeration details:
      | Field      | Value         |
      | First Name | Ushno         |
      | Last Name  | Gorom         |
      | Address    | 29/C StreetA  |
      | City       | CityA         |
      | State      | StateA        |
      | Zip Code   |        123456 |
      | Phone #    |    1234567890 |
      | SSN        |     123567984 |
      | Username   | ushnogorom123 |
      | Password   | sehun@123     |
      | Confirm    | sehun@123     |
    And user clicks on 'Register' button
    Then verify user is navigated to "Welcome" page
    And verify welcome title "Welcome ushnogorom123" is displayed in 'Welcome' page
