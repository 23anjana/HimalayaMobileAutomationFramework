package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuizPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/text_view_toolbar_title']")
    WebElement quizPageElement;

    @FindBy(xpath = "//android.widget.Button[@resource-id='quiz-kit-intro-button']")
    WebElement startButton;

    String xpathForAge = "//android.widget.ToggleButton[contains(@text,'%s')]";

    @FindBy(xpath = "//android.widget.Button[@text='No Thanks']")
    WebElement noThanksButton;

    @FindBy(xpath = "//android.widget.Button[@text='SUBMIT AND SEE RESULTS']")
    WebElement submitButton;

    @FindBy(xpath = "//android.view.View[@resource-id='quiz-kit-container']")
    WebElement healthTips;

    String xpathForButton = "//android.widget.Button[@text='%s']";

    @FindBy(xpath = "//android.widget.TextView[@text='How many years have you graced our planet?']")
    WebElement newPageQuestion;

    @FindBy(xpath = "")
    WebElement successfullyAdded;

    public boolean isQuizPageDisplayed() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return quizPageElement.isDisplayed();
    }

    public void clicksOnStartQuiz() {
        Dimension dimension=driver.manage().window().getSize();
        int width =dimension.getWidth();
        int height = dimension.getHeight();

        scrollOrSwipe(width/2,height/2,width/2,0);
        startButton.click();

    }

    public void selectAge(String key){
        WebElement ageBox = driver.findElement(By.xpath(String.format(xpathForAge,key)));
        ageBox.click();
    }

    public void clickOnSubmitButton(){
        noThanksButton.click();
        waitForElementToBeVisible(submitButton);
        submitButton.click();
    }

    public boolean isHealthTipsDisplayed() {
        waitForElementToBeVisible(healthTips);
        return healthTips.isDisplayed();
    }

    public void clicksOnRetakeAndAddAllButton(String buttonName) {
        WebElement retakeAndAddButton = driver.findElement(By.xpath(String.format(xpathForButton,buttonName)));
        Dimension dimension=driver.manage().window().getSize();
        int width =dimension.getWidth();
        int height = dimension.getHeight();

        while (true){
            try {
                retakeAndAddButton.isDisplayed();
                break;
            }catch (Exception e){
                scrollOrSwipe(width/2,height/2,width/2,0);
            }
        }
        retakeAndAddButton.click();
    }

    public boolean isNewQuizPageDisplayed() {
        return  quizPageElement.isDisplayed() && newPageQuestion.isDisplayed();
    }

    public boolean isAllProductsAddedToCart() {
        return successfullyAdded.isDisplayed();
    }
}
