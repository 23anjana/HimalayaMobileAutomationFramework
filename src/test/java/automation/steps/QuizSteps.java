package automation.steps;

import automation.pages.QuizPage;
import automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class QuizSteps {

    QuizPage quizPage = new QuizPage();

    @Then("verify corresponding page displayed")
    public void verifyCorrespondingPageDisplayed() {
        Assert.assertTrue(quizPage.isQuizPageDisplayed());
    }

    @When("user clicks on START QUIZ button")
    public void userClicksOnSTARTQUIZButton() {
        quizPage.clicksOnStartQuiz();
    }

    @And("user choose  {string} option and clicks on next button")
    public void userChooseOptionAndClicksOnNextButton(String key) {
        quizPage.selectAge(ConfigReader.getConfigValue(key));
    }

    @And("user clicks on submit and see results")
    public void userClicksOnSubmitAndSeeResults() {
        quizPage.clickOnSubmitButton();
    }

    @Then("verify health tips are given based on the quiz")
    public void verifyHealthTipsAreGivenBasedOnTheQuiz() {
        Assert.assertTrue(quizPage.isHealthTipsDisplayed());
    }


    @When("user clicks on  {string} button")
    public void userClicksOnButton(String key) {
        quizPage.clicksOnRetakeAndAddAllButton(ConfigReader.getConfigValue(key));
    }

    @Then("verify new quiz page is displayed")
    public void verifyNewQuizPageIsDisplayed() {
        Assert.assertTrue(quizPage.isNewQuizPageDisplayed());
    }


    @Then("verify all products added to cart")
    public void verifyAllProductsAddedToCart() {
        Assert.assertTrue(quizPage.isAllProductsAddedToCart());
    }
}
