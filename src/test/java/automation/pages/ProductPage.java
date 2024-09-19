package automation.pages;

import automation.utils.ConfigReader;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends  BasePage{

    @FindBy(id = "in.himalayawellness:id/text_view_toolbar_title")
    WebElement productTitlePage;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='in.himalayawellness:id/parent']")
    List<WebElement> selectProduct;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD']")
    WebElement addIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='VIEW FULL DESCRIPTION']")
    WebElement viewFullDescription;

    @FindBy(className = "android.widget.TextView")
    List<WebElement> descriptionTitle;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement closeButton;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='in.himalayawellness:id/productImage']")
    List<WebElement> selectCategoryProduct;

    @FindBy(id = "in.himalayawellness:id/btnAddToFavPDP")
    WebElement wishListIcon;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='in.himalayawellness:id/rvProductList']//android.widget.TextView[@resource-id='in.himalayawellness:id/tvProductName']")
    List<WebElement> clickOnAProduct;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement navigateBackButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/text_view_toolbar_title']")
    WebElement titleElement;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='in.himalayawellness:id/productImage'])[1]")
    WebElement firstProduct;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView")
    List<WebElement> listOfProductsOption;

    @FindBy(id = "in.himalayawellness:id/text_view_toolbar_title")
    WebElement filterPageTitle;

    @FindBy(id = "in.himalayawellness:id/lLFilterLayout")
    WebElement filterButton;

    String xpathForProductTypeName = "//android.widget.CheckBox[@resource-id='in.himalayawellness:id/filter_value_checkbox' and contains(@text,'%s')]";

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/tvSort']")
    WebElement sortButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Title: A-Z']")
    WebElement sortAtoZ;

    @FindBy(xpath = "//android.widget.TextView[@text='Title: Z-A']")
    WebElement sortZtoA;

    public String isSearchResultDisplayed() {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        waitForElementToBeVisible(productTitlePage);
        return productTitlePage.getText();
    }

    public String isProductDisplayed() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        waitForElementToBeVisible(productTitlePage);
        return productTitlePage.getText();
    }

    public void addItemToCart() {
        selectProduct.get(2).click();

        // scroll function
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(viewFullDescription)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Views full description
        waitForElementToBeClickable(viewFullDescription);
        viewFullDescription.click();

        // Closes the description page
        closeButton.click();

        // Adds the item to cart
        addIcon.click();
    }

    public void clickOnAProduct() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Function is called to scroll to the end
        scrollToEnd();

        selectCategoryProduct.get(4).click();
    }

    public void wishListTheItem() {
        wishListIcon.click();
    }

    public void chooseACategoryProduct() {
        clickOnAProduct.get(0).click();
    }

    public void addAnotherProductToCart() {

        // Navigates to the previous page
        navigateBackButton.click();

        // Clicks on the second product
        clickOnAProduct.get(1).click();

        // Adds the item to cart
        addIcon.click();
    }

    public boolean isProductPageDisplayed() {
        return titleElement.isDisplayed();
    }

    public void chooseFirstProduct() {
        firstProduct.click();
    }

    public void clicksOnFilterOption(String filterOption) {
        List<String> filterNames = listOfProductsOption.stream().map(WebElement::getText).toList();
        int startX = listOfProductsOption.get(listOfProductsOption.size() - 1).getLocation().getX();
        int startY = listOfProductsOption.get(listOfProductsOption.size() - 1).getLocation().getY();

        while (true) {
            String firstBlock = filterNames.get(0);
            if (filterNames.contains(filterOption)) {
                driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView[@text='" + filterOption + "']")).click();
                break;
            } else {
                scrollOrSwipe(startX, startY, startX - 900, startY);
                listOfProductsOption = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView"));
                filterNames = listOfProductsOption.stream().map(WebElement::getText).toList();
                String refreshedFirstBlock = filterNames.get(0);
                if (firstBlock.equals(refreshedFirstBlock)) {
                    System.out.println("No filter options is there");
                    Assert.assertTrue(false);
                    break;
                }
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String isFilteredPageDisplayed() {
        return filterPageTitle.getText();
    }

    public void clicksOnFilterButton() {
        filterButton.click();
    }
    public void chooseCheckBox(String key) {
        WebElement productTypeName = driver.findElement(By.xpath(String.format(xpathForProductTypeName,key)));
        productTypeName.click();
    }

    public void clicksOnSortButton() {
        waitForElementToBeClickable(sortButton);
        sortButton.click();
    }

    public void chooseSortOptionAtoZ() {
        waitForElementToBeVisible(sortAtoZ);
        sortAtoZ.click();
    }

    public void chooseSortOptionZtoA() {
        waitForElementToBeVisible(sortZtoA);
        sortZtoA.click();
    }

}
