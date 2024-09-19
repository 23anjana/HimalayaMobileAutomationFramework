package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement navigateBackButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Wishlist']")
    WebElement wishListIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/product_name']")
    WebElement productName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/product_text']")
    List<WebElement> wishListedProduct;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='in.himalayawellness:id/btnAddToFav']")
    WebElement heartIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/tvEmptyWishlistTitle']")
    WebElement emptyWishList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/tv_option_values']")
    List<WebElement> options;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD']")
    WebElement addIcon;

    String name;
    String wishListedProductName;

    public void goToWishListPage() {

        name = productName.getText();

        navigateBackButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        waitForElementToBeClickable(navigateBackButton);
        navigateBackButton.click();

        wishListIcon.click();
    }

    public boolean isProductAddedToWishList() {
        wishListedProductName = wishListedProduct.get(0).getText();
        System.out.println("Product name: " + name);
        System.out.println("WishListed product name: " + wishListedProductName);
        System.out.println("The product is successfully WishListed");
        return name.equals(wishListedProductName);
    }

    public void removeWishListedProduct() {
        heartIcon.click();
    }

    public boolean isProductRemovedFromWishList() {
        String emptyWishListMessage = emptyWishList.getText();
        System.out.println("Empty WishList message: " + emptyWishListMessage);
        System.out.println("The product is successfully removed from WishList");
        return emptyWishList.isDisplayed();
    }

    public void addsWishListedProductToCart() {
        wishListedProduct.get(0).click();
        options.get(1).click();
        addIcon.click();
    }
}
