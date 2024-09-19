Feature: Validate search functionality of Himalaya Wellness

  Background:
    Given user opens the application
    Then verify user is on home page

  Scenario: Verify user can search product through search bar
    When user enters "search.keyword" in the search bar
    Then verify search result page is displayed

  Scenario: Verify user can search an item from the Menu
    When user clicks on the hamburger menu icon
    And user chooses a main category
    And user chooses a sub category
    And user chooses a product category
    Then verify result page is displayed