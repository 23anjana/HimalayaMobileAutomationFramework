package automation.pages;

import automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElementIfPresent(WebElement element) {
        if (isPresent(element)) {
            element.click();
        }
    }

    public void scrollOrSwipe(int startX,int startY,int endX,int endY){
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // Sequence is a requestSpecification
        driver.perform(Collections.singletonList(sequence));
    }

    public void scrollToEnd() {
        Dimension dimension = driver.manage().window().getSize();
        int startX = dimension.getWidth() / 2;
        int startY = (int) (dimension.getHeight() * 0.85);
        int endY = (int) (dimension.getHeight() * 0.15);

        // Perform a swipe gesture to scroll down
        scrollOrSwipe(startX, startY, startX, endY);
    }

    public boolean isPresentNew(WebElement element) {
        try {
            resetImplicitWait(0);
            return element.isDisplayed();
//            wait.until(ExpectedConditions.visibilityOf(element));
//            return true;
        } catch (Exception e) {
            return false;
        }finally {
            resetImplicitWait(60);
        }
    }
    public void resetImplicitWait(long sec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

}


