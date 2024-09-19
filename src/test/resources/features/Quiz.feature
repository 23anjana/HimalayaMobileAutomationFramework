Feature: Validate Quiz functionality of Himalaya Wellness

  Background:
    Given user opens the application
    Then  verify user is on home page
    When user clicks on Cardiac Wellness under take our quiz section
    Then verify corresponding page displayed
    When user clicks on START QUIZ button
    And  user choose  "quiz.age" option and clicks on next button
    And  user choose  "quiz.gender" option and clicks on next button
    And  user choose  "quiz.other.concerns" option and clicks on next button
    And  user choose  "quiz.other.concerns2" option and clicks on next button
    And  user clicks on submit and see results

  Scenario: verify user can take the quiz
    Then verify health tips are given based on the quiz

  Scenario: verify user can add recommended products into cart
    When  user clicks on  "quiz.button.addAllToBag" button
    Then  verify all products added to cart

  Scenario: verify user can retake quiz
    When user clicks on  "quiz.button.retake" button
    Then verify new quiz page is displayed












