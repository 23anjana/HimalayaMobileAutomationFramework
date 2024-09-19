package automation.steps;

import automation.pages.HomePage;
import automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Given("user opens the application")
    public void user_opens_the_application() {
        homePage.openApplication();
    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }
    @When("user enters {string} in the search bar")
    public void userEntersInTheSearchBar(String productName) {
        homePage.searchProduct(ConfigReader.getConfigValue(productName));
    }

    @When("user clicks on the hamburger menu icon")
    public void userClicksOnTheHamburgerMenuIcon() {
        homePage.clickOnHamBurgerMenu();
    }

    @And("user chooses a main category")
    public void userChoosesAMainCategory() {
        homePage.chooseMainCategory();
    }

    @And("user chooses a sub category")
    public void userChoosesASubCategory() {
        homePage.chooseTheSubCategory();
    }

    @And("user chooses a product category")
    public void userChoosesAProductCategory() {
        homePage.chooseProductCategory();
    }

    @When("user chooses a category")
    public void userChoosesACategory() {
        homePage.chooseCategory();
    }

    @When("user chooses a category from the categories listed on the page")
    public void userChoosesACategoryFromTheCategoriesListedOnThePage() {
        homePage.chooseCategoryBySwiping();
    }


    @And("user searches for {string} on search bar")
    public void userSearchesForOnSearchBar(String key) {
        homePage.searchProduct(ConfigReader.getConfigValue(key));
    }

    @When("user navigates back to the previous page")
    public void userNavigatesBackToThePreviousPage() {
        homePage.navigateBack();
    }

    @When("user chooses {string} option")
    public void userChoosesOption(String productName) {
        homePage.clickFilterProduct(ConfigReader.getConfigValue(productName));
    }

    @When("user choose Baby Care option")
    public void userChooseBabyCareOption() {
        homePage.chooseOption();
    }
    @When("user clicks on Cardiac Wellness under take our quiz section")
    public void userClicksOnCardiacWellnessUnderTakeOurQuizSection() {
        homePage.clickQuizOption();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
