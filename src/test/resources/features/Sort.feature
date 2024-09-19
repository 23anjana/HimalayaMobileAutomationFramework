Feature: Validate Sorting functionality of Himalaya Wellness

  Background:
    Given user opens the application
    Then  verify user is on home page
    When  user choose Baby Care option
    Then  verify  product page is displayed
    When  user clicks on sort button

  Scenario: Verify user can sort products based on Title A-Z
    And   user choose the title A-Z option
    Then  verify product displayed is in sorted order by  title A-Z

  Scenario: Verify user can sort products based on Title Z-A
    And   user choose the title Z-A option
    Then  verify product displayed is in sorted order by  title Z-A

