package automation.pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends  BasePage {
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")
    WebElement denyButton;

    @FindBy(id = "in.himalayawellness:id/tv_title_center")
    WebElement homePageView;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/searchbar_hint_textview']")
    WebElement searchBar;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='in.himalayawellness:id/suggestion_product_textview']")
    WebElement searchField;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement hamBurgerMenu;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/text_title']")
    List<WebElement> selectMainCategory;

    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='in.himalayawellness:id/node_header']")
    List<WebElement> selectSubCategory;

    @FindBy(xpath = "//android.widget.TextView[@text='Personal Care']")
    WebElement personalCare;

    @FindBy(xpath = "//android.widget.TextView[@text='Baby Care']")
    WebElement babyCare;

    @FindBy(xpath = "//android.widget.TextView[@text='Animal Health']")
    WebElement animalHealth;

    @FindBy(xpath = "//android.widget.TextView[@text='Nutrition']")
    WebElement nutrition;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement backButton;

    String xpathForProductName = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.TextView[@text='Pharmaceuticals']")
    WebElement pharmaceuticalsElement;

    @FindBy(xpath = "//android.widget.TextView[@text='Personal Care']")
    WebElement personalCareElement;

    @FindBy(xpath = "//android.widget.TextView[@text='Baby Care']")
    WebElement babyCareOption;

    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id='in.himalayawellness:id/rvDynamicList'])[2]")
    WebElement takeQuizElement;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='in.himalayawellness:id/product_image'])[3]")
    WebElement cardiacWellness;


    // Opens the application
    public void openApplication() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        waitForElementToBeClickable(denyButton);
        if(isPresent(denyButton)) {
            denyButton.click();
        }

        if(isPresent(denyButton)) {
            denyButton.click();
        }
    }

    public boolean isHomePageDisplayed() {
        return homePageView.isDisplayed();
    }

    public void searchProduct(String searchKeyword) {
        searchBar.click();
        searchField.sendKeys(searchKeyword);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER)
                .pause(1000)
                .keyUp(Keys.ENTER)
                .build().perform();
    }

    public void clickOnHamBurgerMenu() {
        hamBurgerMenu.click();
    }

    public void chooseMainCategory() {
        selectMainCategory.get(2).click();
    }

    public void chooseTheSubCategory() {
        waitForElementToBeClickable(selectSubCategory.get(8));
        selectSubCategory.get(8).click();
    }

    public void chooseProductCategory() {
        waitForElementToBeClickable(selectMainCategory.get(10));
        selectMainCategory.get(10).click();
    }

    public void chooseCategory() {

        // Swipes till animal Health category is found
        int startX = babyCare.getLocation().getX();
        int startY = babyCare.getLocation().getY();

        int endX = personalCare.getLocation().getX();
        int endY = personalCare.getLocation().getY();

        while (!isPresent(animalHealth)) {
            scrollOrSwipe(startX, startY, endX, endY);
        }

        waitForElementToBeVisible(animalHealth);
        animalHealth.click();
    }

    public void chooseCategoryBySwiping() {

        // Swipes till nutrition category is found
        int startX = babyCare.getLocation().getX();
        int startY = babyCare.getLocation().getY();

        int endX = personalCare.getLocation().getX();
        int endY = personalCare.getLocation().getY();

        while (!isPresent(nutrition)) {
            scrollOrSwipe(startX, startY, endX, endY);
        }

        waitForElementToBeVisible(nutrition);
        nutrition.click();
    }

    public void navigateBack() {
        backButton.click();
    }

    public void clickFilterProduct(String productName) {
        WebElement product = driver.findElement(By.xpath(String.format(xpathForProductName,productName)));
        waitForElementToBeClickable(product);
        product.click();
    }

    public void chooseOption() {
        int startX = pharmaceuticalsElement.getLocation().getX();
        int startY = pharmaceuticalsElement.getLocation().getY();

        int endX = personalCareElement.getLocation().getX();
        int endY = personalCareElement.getLocation().getY();

        scrollOrSwipe(startX, startY, endX, endY);
        waitForElementToBeVisible(babyCareOption);
        babyCareOption.click();
    }

    public void clickQuizOption()
    {
        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        boolean flag=true;
        while (flag){
            try {
                takeQuizElement.isDisplayed();
                break;
            }catch (Exception e){
                scrollOrSwipe(width/2,height/2,width/2,0);
            }
        }
        cardiacWellness.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
