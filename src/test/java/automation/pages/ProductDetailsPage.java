package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='ADD']")
    WebElement addToCartButton;

    public void clickAddToCartButton() {
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }
}
