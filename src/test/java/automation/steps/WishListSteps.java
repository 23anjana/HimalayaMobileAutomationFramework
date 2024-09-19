package automation.steps;

import automation.pages.WishListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WishListSteps {

    WishListPage wishListPage = new WishListPage();

    @Then("verify the product is added to wishlist")
    public void verifyTheProductIsAddedToWishlist() {
        wishListPage.goToWishListPage();
       Assert.assertTrue(wishListPage.isProductAddedToWishList());
    }

    @When("user clicks on the wishList heart icon")
    public void userClicksOnTheWishListHeartIcon() {
        wishListPage.removeWishListedProduct();
    }

    @Then("verify the product is removed from wishList")
    public void verifyTheProductIsRemovedFromWishList() {
        Assert.assertTrue(wishListPage.isProductRemovedFromWishList());
    }

    @When("user clicks on the product and adds it to cart")
    public void userClicksOnTheProductAndAddsItToCart() {
        wishListPage.addsWishListedProductToCart();
    }
}
