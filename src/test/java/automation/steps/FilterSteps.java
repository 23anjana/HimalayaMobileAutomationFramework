package automation.steps;

import automation.pages.FilterPage;
import automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FilterSteps {
    FilterPage filterPage = new FilterPage();

    @And("user choose {string} option")
    public void userChooseOption(String key) {
        filterPage.clicksOnFilterTags(ConfigReader.getConfigValue(key));

    }

    @And("user choose In Stock option")
    public void userChooseInStockOption() {
        filterPage.clicksOnInStock();
    }

    @Then("verify products are filtered based on availability")
    public void verifyProductsAreFilteredBasedOnAvailability() {
        Assert.assertTrue(filterPage.isProductsDisplayedBasedOnInStock());
    }

    @Then("verify products are filtered based on product type {string}")
    public void verifyProductsAreFilteredBasedOnProductType(String key) {
        Assert.assertTrue(filterPage.isProductsDisplayedBasedOnProductType(ConfigReader.getConfigValue(key)));
    }
}
