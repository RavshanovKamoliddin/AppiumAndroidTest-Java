package Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SwipeAndroidTest {
    public AndroidDriver<MobileElement> driver;
    public AndroidTouchAction actions;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackages", "com.hmh.api");
        capabilities.setCapability("appActivity", ".ApiDemos");
        
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void swipe_test() {
        AndroidElement views = (AndroidElement)
                driver.findElementByXPath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Views\"]");

        // Tap
        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();

        AndroidElement gallery = (AndroidElement)
                driver.findElementByXPath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Gallery\"]");
        actions.tap(ElementOption.element(gallery)).perform();

        AndroidElement photo = (AndroidElement)
                driver.findElementByXPath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"1. Photos\"]");
        actions.tap(ElementOption.element(photo)).perform();

        AndroidElement pic1 = (AndroidElement)
                driver.findElements(By.className("android.widget.ImageView")).get(0);

        actions.press(ElementOption.element(pic1))
                .waitAction()
                .moveTo(PointOption.point(-20, 210))
                .release()
                .perform();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
