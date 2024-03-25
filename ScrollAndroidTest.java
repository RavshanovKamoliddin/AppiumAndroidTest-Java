package Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ScrollAndroidTest {

    public AndroidDriver <MobileElement> driver;
    public AndroidTouchAction actions;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("appPackages","com.hmh.api");
        capabilities.setCapability("appActivity",".ApiDemos");
       
        //appium URL
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @Test
    private void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getWidth() * 0.21);
      //  int scrollStart = (int) (dimension.getHeight() * 0.1);
        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(6)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }
    @Test
    public void scroll_test() {

        driver.findElementByAccessibilityId("API Demos").click();
        AndroidElement views =
                (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Views\"]");
        // Tap
        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();
        // ScrollDown
        scrollDown();
        AndroidElement Lists = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Lists\"]");
        actions.tap(ElementOption.element(Lists)).perform();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
