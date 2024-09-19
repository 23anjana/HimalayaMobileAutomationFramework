package automation.steps;

import automation.pages.ProductPage;
import automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {
    ProductPage productPage = new ProductPage();

    @Then("verify search result page is displayed")
    public void verifySearchResultPageIsDisplayed() {
        Assert.assertEquals(productPage.isSearchResultDisplayed(), "face wash");
    }

    @Then("verify result page is displayed")
    public void verifyResultPageIsDisplayed() {
        Assert.assertEquals(productPage.isProductDisplayed(), "Eye Care");
    }

    @When("user views the product description and add item to cart")
    public void userViewsTheProductDescriptionAndAddItemToCart() {
        productPage.addItemToCart();
    }

    @Then("verify category page is displayed")
    public void verifyCategoryPageIsDisplayed() {
        Assert.assertEquals(productPage.isProductDisplayed(), "Animal Health");
    }

    @When("user chooses a product")
    public void userChoosesAProduct() {
        productPage.clickOnAProduct();
    }

    @And("user adds the product to wishlist")
    public void userAddsTheProductToWishlist() {
        productPage.wishListTheItem();
    }

    @Then("verify result page of category is displayed")
    public void verifyResultPageOfCategoryIsDisplayed() {
        Assert.assertEquals(productPage.isProductDisplayed(), "Nutrition");
    }

    @And("user chooses any product")
    public void userChoosesAnyProduct() {
        productPage.chooseACategoryProduct();
    }

    @And("user wishLists the product")
    public void userWishListsTheProduct() {
        productPage.wishListTheItem();
    }

    @And("user adds another item to cart")
    public void userAddsAnotherItemToCart() {
        productPage.addAnotherProductToCart();
    }

    @Then("verify  product page is displayed")
    public void verifyProductPageIsDisplayed() {
        Assert.assertTrue(productPage.isProductPageDisplayed());
    }

    @When("user choose  first product")
    public void userChooseFirstProduct() {
        productPage.chooseFirstProduct();
    }

    @When("user clicks on {string} option")
    public void userClicksOnOption(String productOption) {
        productPage.clicksOnFilterOption(ConfigReader.getConfigValue(productOption));
    }

    @Then("verify corresponding {string} products are displayed")
    public void verifyCorrespondingProductsAreDisplayed(String key) {
        Assert.assertEquals(productPage.isFilteredPageDisplayed(),ConfigReader.getConfigValue(key));
    }

    @When("user clicks on filter button")
    public void userClicksOnFilterButton() {
        productPage.clicksOnFilterButton();
    }


    @And("user choose {string} check box")
    public void userChooseCheckBox(String key) {
        productPage.chooseCheckBox(ConfigReader.getConfigValue(key));
    }

    @When("user clicks on sort button")
    public void userClicksOnSortButton() {
        productPage.clicksOnSortButton();
    }

    @And("user choose the title A-Z option")
    public void userChooseTheTitleAZOption() {
        productPage.chooseSortOptionAtoZ();
    }

    @And("user choose the title Z-A option")
    public void userChooseTheTitleZAOption() {
        productPage.chooseSortOptionZtoA();
    }
}
