package automation.steps;

import automation.pages.ProductDetailsPage;
import io.cucumber.java.en.And;

public class ProductDetailsSteps {
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @And("user clicks on ADD TO BAG button")
    public void userClicksOnADDTOBAGButton() {
        productDetailsPage.clickAddToCartButton();
    }


}
