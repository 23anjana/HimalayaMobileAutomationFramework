package automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static AppiumDriver driver;

    public static void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
        capabilities.setCapability("appium:app", "C://Users//280661//Downloads//Himalaya//in.himalayawellness.apk");  // The filename of the mobile app
        capabilities.setCapability("appium:deviceName", "36424a00");
        capabilities.setCapability("appium:automationName", ConfigReader.getConfigValue("automation.name"));
        capabilities.setCapability("appActivity",ConfigReader.getConfigValue("app.activity"));
        capabilities.setCapability("appPackage",ConfigReader.getConfigValue("app.package"));


        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
