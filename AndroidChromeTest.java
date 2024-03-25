package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;



public class AndroidChromeTest {
    public AndroidDriver<MobileElement> driver;
   // public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("appPackages", "com.google.android.gms.common.api");
        capabilities.setCapability("appActivity", ".GoogleApiActivity");

        driver = new AndroidDriver <MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @Test
    public void newContact() throws InterruptedException {

        Thread.sleep(3000);
        MobileElement contact = driver.findElementByAccessibilityId("Contacts");
        contact.click();

        Thread.sleep(300);

        MobileElement create = (MobileElement) driver.findElements(By.id("com.google.android.contacts:id/floating_action_button"));
        create.click();

        Thread.sleep(300);

        MobileElement firstname = driver.findElementByXPath("//android.widget.EditText[@text=\"First name\"]");
        firstname.click();
        firstname.sendKeys("Kamoliddin");

        MobileElement lastname = driver.findElementByXPath("//android.widget.EditText[@text=\"Last name\"]");
        lastname.click();
        lastname.sendKeys("Ravshanov");

        MobileElement company = driver.findElementByXPath("//android.widget.EditText[@text=\"Company\"]");
        company.click();
        company.sendKeys("CodeKaplan");

        Thread.sleep(300);

        MobileElement phone = driver.findElementByXPath("//android.widget.EditText[@text=\"Phone\"]");
        phone.click();
        phone.sendKeys("+998901777777");

        MobileElement save = driver.findElementById("com.google.android.contacts:id/toolbar_button");
        save.click();


    }
    @AfterTest
    public void tearDown()
    {
        if (null != driver) {
            driver.quit();
        }
    }

}
