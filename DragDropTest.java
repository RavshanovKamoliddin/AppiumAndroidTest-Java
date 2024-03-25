package Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class DragDropTest {

    public AndroidDriver<MobileElement> driver;
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
    
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
}


    @Test
    public void drag_drop() {
        AndroidElement views = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Views\"]");

        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();

        AndroidElement drag_drop = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Drag and Drop\"]");
        actions.tap(ElementOption.element(drag_drop)).perform();

        AndroidElement drag = (AndroidElement) driver.findElement(By.id("com.hmh.api:id/drag_dot_1"));

        AndroidElement drop = (AndroidElement) driver.findElement(By.id("com.hmh.api:id/drag_dot_2"));

        actions.longPress(ElementOption.element(drag)).
                waitAction().moveTo(ElementOption.element(drop))
                .release().perform();

    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}

