Feature: User Registration

  Scenario: 1.1 Landing on the homepage
    Given I am on the homepage
    Then the "Create an Account" link is visible in the top right corner

  Scenario: 1.2 Navigation to the Registration Page
    Given I am on the homepage
    When I click the "Create an Account" link
    Then I am taken to the registration page
    And the registration form fields are visible

  Scenario: 1.3.1 Fill in the form
    Given I am on the registration form page
    Then the form includes fields for first name, last name, email address, password, and password confirmation