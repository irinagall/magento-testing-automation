Feature: User Registration

  @Happy
  Scenario: 1.1 Landing on the homepage
    Given I am on the homepage
    Then the "Create an Account" link is visible in the top right corner

  @Happy
  Scenario: 1.2 Navigation to the Registration Page
    Given I am on the homepage
    When I click the "Create an Account" link
    Then I am taken to the registration page
    And the registration form fields are visible

  @Happy
  Scenario: 1.3.1 Fill in the form
    Given I am on the registration form page
    Then the form includes fields for first name, last name, email address, password, and password confirmation

  @Sad
  Scenario: 1.3.2 Passwords do not match
    Given I am on the registration form page
    When I enter "password123" into the password field
    And I enter "password456" into the confirmation password field
    Then a message "Please enter the same value again." will display
