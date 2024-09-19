package automation.steps;

import automation.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify the product is successfully added to cart")
    public void verifyTheProductIsSuccessfullyAddedToCart() {
        Assert.assertTrue(cartPage.isProductAddedToCart());
    }

    @When("user clicks on minus button to remove item")
    public void userClicksOnMinusButtonToRemoveItem() {
        cartPage.removeFromCart();
    }

    @Then("verify product is removed from the cart")
    public void verifyProductIsRemovedFromTheCart() {
        cartPage.isProductRemovedFromCart();
    }

    @When("user clicks on SHOP NOW button")
    public void userClicksOnSHOPNOWButton() {
        cartPage.clickOnShopNowButton();
    }

    @And("user clicks on ADD MORE FROM WISHLIST option")
    public void userClicksOnADDMOREFROMWISHLISTOption() {
        cartPage.addMoreToCart();
    }

    @Then("verify the wishListed product is added to cart")
    public void verifyTheWishListedProductIsAddedToCart() {
        Assert.assertTrue(cartPage.isWishListedProductAddedToCart());
    }

    @When("user clicks on bag icon")
    public void userClicksOnBagIcon() {
        cartPage.clicksOnAddToCartIcon();
    }

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        Assert.assertEquals(cartPage.isCartPageDisplayed(),"Cart");
    }

    @And("verify item prices display correctly on cart page")
    public void verifyItemPricesDisplayCorrectlyOnCartPage() {
        Assert.assertTrue(cartPage.isPriceDisplayedIsCorrect());
    }
}
