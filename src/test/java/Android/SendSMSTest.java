package Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SendSMSTest {
    public AndroidDriver <MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackages", "com.google.android.apps.messaging");
        capabilities.setCapability("appActivity", ".ui.conversation.LaunchConversationActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void sen_sms_test() {

        driver.sendSMS("555-123-4567", "Hello Automation Testing");
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}