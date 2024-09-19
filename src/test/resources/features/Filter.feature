Feature: Validate Filter functionality of Himalaya Wellness

  Background:
    Given user opens the application
    Then  verify user is on home page
    When  user chooses "filter.product" option
    Then  verify  product page is displayed

  Scenario: Verify user can filter products
    When  user clicks on "filter.option" option
    Then  verify corresponding "filter.option" products are displayed

  Scenario: Verify user can filter products based on availability
    When user clicks on filter button
    And  user choose "filter.tag.availability" option
    And  user choose In Stock option
    Then verify products are filtered based on availability


  Scenario: Verify user can filter based on product type
    When user clicks on filter button
    And  user choose "filter.tag.product.type" option
    And  user choose "filter.tag.product.type.name" check box
    Then verify products are filtered based on product type "filter.tag.product.type.name"



