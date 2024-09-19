Feature: Validate Wishlist functionality of Himalaya

  Background:
    Given user opens the application
    Then verify user is on home page

  Scenario: Verify user can add product to wishlist
    When user chooses a category
#    Then verify category page is displayed
    When user chooses a product
    And user adds the product to wishlist
    Then verify the product is added to wishlist

  Scenario: Verify user can remove product from wishlist
    When user chooses a category
#   Then verify category page is displayed
    When user chooses a product
    And user adds the product to wishlist
    Then verify the product is added to wishlist
    When user clicks on the wishList heart icon
    Then verify the product is removed from wishList


    





