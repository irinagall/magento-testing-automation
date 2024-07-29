Feature: Search Function
  To be able to find the product I am looking for
  As a customer,
  I want to be able to use the search bar to see if the store sells the product I am looking for

  @Happy
  Scenario: Search for valid product
    Given I am on the home page
    When I type in "Driven Backpack" to the search bar
    And clicked the search button
    Then the first item returned should be "Driven Backpack"