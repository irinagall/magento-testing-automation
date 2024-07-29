Feature: 2.5 - Provide shipping details

  As a logged in user,
  I want to be able to provide shipping details
  so that my order can be shipped to the correct location

  Scenario: 2.5.1 - Proceeding to checkout brings up shipping details form
    Given I have added an item to my cart
    When I click to proceed to checkout
    Then I am redirected to the shipping details page

  Scenario: 2.5.2 - Entering full shipping details progresses the checkout workflow
    Given I have added an item to my cart
    And I have proceeded to the shipping details form
    When I enter the following shipping address
      | test@email.com | Bob | Jones | Company A | 123 Test Street | Test City | Alabama | ABCD 123 | Afghanistan | 1234 56789 |
    And I select a fixed shipping method
    And I click next
    Then I am taken to the payment page