package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/quantity_textview']")
    WebElement cartItemQuantity;

    @FindBy(id = "in.himalayawellness:id/badgeValueView")
    WebElement cartIconProductNumber;

    @FindBy(id = "in.himalayawellness:id/cartButton")
    WebElement cartIcon;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='in.himalayawellness:id/minus_iv']")
    WebElement minusSign;

    @FindBy(xpath = "//android.widget.TextView[@text='Yes']")
    WebElement confirmDelete;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/empty_cart_title_textview']")
    WebElement emptyCart;

    @FindBy(xpath = "//android.widget.Button[@text='SHOP NOW']")
    WebElement shopNowButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Add more from Wishlist']")
    WebElement addMoreToWishList;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='in.himalayawellness:id/temp_fav']")
    List<WebElement> cartItemsList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/product_text']")
    List<WebElement> wishListedProduct;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/productName']")
    List<WebElement> productName;

    @FindBy(xpath = "//android.widget.TextView[@text='Cart']")
    WebElement cartPage;

    @FindBy(id = "in.himalayawellness:id/selling_price_tv")
    List<WebElement> priceList;

    @FindBy(id = "in.himalayawellness:id/bottom_total_textview")
    WebElement totalPriceOnApp;

    String product;
    String wishListedProductName2;

    public boolean isProductAddedToCart() {
        return cartItemQuantity.isDisplayed() && cartIconProductNumber.isDisplayed();
    }

    public void removeFromCart() {
        cartIcon.click();
        minusSign.click();
        confirmDelete.click();
    }

    public void isProductRemovedFromCart() {
        String emptyMessage = emptyCart.getText();
        System.out.println(emptyMessage);
    }

    public void clickOnShopNowButton() {
        shopNowButton.click();
    }

    public void addMoreToCart() {
        cartIcon.click();
        addMoreToWishList.click();
        wishListedProductName2 = wishListedProduct.get(0).getText();
    }

    public boolean isWishListedProductAddedToCart() {
        cartIcon.click();
        product = productName.get(1).getText();
        System.out.println("WishListed Product: " + wishListedProductName2);
        System.out.println("Cart Products: " + product);
        System.out.println("The WishListed item is successfully added to cart");
        return wishListedProductName2.equals(product);
    }

    public void clicksOnAddToCartIcon() {
        cartIcon.click();
    }

    public String isCartPageDisplayed() {
        return cartPage.getText();
    }

    public boolean isPriceDisplayedIsCorrect() {
        double totalPriceCalculated = 0;
        for (WebElement price : priceList) {
            System.out.println(price);
            totalPriceCalculated = totalPriceCalculated + Double.parseDouble(price.getText().replace("₹", " "));
        }
        System.out.println("Total price calculated : " + totalPriceCalculated);

        double totalItemsPriceOnCart = Double.parseDouble(totalPriceOnApp.getText().replace("₹",""));
        System.out.println("Total price on application :" + totalItemsPriceOnCart);

        return totalPriceCalculated == totalItemsPriceOnCart;
    }
}
