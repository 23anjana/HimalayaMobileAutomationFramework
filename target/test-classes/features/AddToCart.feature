Feature: Validate Add To Cart functionality of Himalaya

  Background:
    Given user opens the application
    Then verify user is on home page

  Scenario: Verify user can add product to cart
    When user clicks on the hamburger menu icon
    And user chooses a main category
    And user chooses a sub category
    And user chooses a product category
    Then verify result page is displayed
    When user views the product description and add item to cart
    Then verify the product is successfully added to cart

  Scenario: Verify user can remove product to cart
    When user clicks on the hamburger menu icon
    And user chooses a main category
    And user chooses a sub category
    And user chooses a product category
    Then verify result page is displayed
    When user views the product description and add item to cart
    Then verify the product is successfully added to cart
    When user clicks on minus button to remove item
    Then verify product is removed from the cart
    When user clicks on SHOP NOW button
    Then verify user is on home page

  Scenario: Verify user can add a wishListed product to cart
    When user chooses a category from the categories listed on the page
    Then verify result page of category is displayed
    And user chooses any product
    And user wishLists the product
    And user adds another item to cart
    And user clicks on ADD MORE FROM WISHLIST option
#    Then verify the product is added to wishlist
    When user clicks on the product and adds it to cart
    Then verify the wishListed product is added to cart