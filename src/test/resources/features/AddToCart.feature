Feature: 2.1 - Add an item to the cart

  As a logged in customer
  I want to be able to add a product to the shopping cart
  so that I can purchase it at a later point

  Background:
    Given I am on the Bags page

  @Happy
  Scenario: Bags items are displayed
    When I view the list of items shown
    Then multiple items are displayed

  @Happy
  Scenario: Navigating to a product page
    When I view the list of items shown
    And I click on the first item shown
    Then I am redirected to the product page for "Push It Messenger Bag"

  @Happy
  Scenario: 2.1.1 - Add item to the cart
    When I view the list of items shown
    And I click on the first item shown
    And I click to add that item to the cart
    Then the count next to the cart icon increases by one