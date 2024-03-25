package Android;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTestAndroid {
    AppiumDriver <MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformVersion","13.0");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("appPackages","com.google.android.calculator2");
        capabilities.setCapability("appActivity",".Calculator");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @Test
    public void click_App_Button() {
        //code
        driver.findElementByAccessibilityId("Calculator").click();
        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementByAccessibilityId("6").click();
        driver.findElementByAccessibilityId("equals").click();

    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
