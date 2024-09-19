Feature: Validate Check out functionality of  Himalaya Wellness

  Scenario:Verify user can see correct prices in cart page

    Given user opens the application
    Then  verify user is on home page
    When  user searches for "product.first_name" on search bar
    Then  verify  product page is displayed
    When  user choose  first product
    And   user clicks on ADD TO BAG button
    Then  verify the product is successfully added to cart
    When  user navigates back to the previous page
    And   user searches for "product.second_name" on search bar
    Then  verify  product page is displayed
    When  user choose  first product
    And   user clicks on ADD TO BAG button
    Then  verify the product is successfully added to cart
    When  user clicks on bag icon
    Then  verify user is on cart page
    And   verify item prices display correctly on cart page








