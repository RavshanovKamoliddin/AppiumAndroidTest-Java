package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestContact {

    public AppiumDriver < MobileElement> driver;

    {
    DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("appPackages", "com.google.android.gms");
        capabilities.setCapability("appActivity", ".GoogleApiActivity");

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void newContact() throws InterruptedException {

        Thread.sleep(3000);

        MobileElement contact = driver.findElementByAccessibilityId("Contacts");
        contact.click();

        Thread.sleep(3000);

        MobileElement create = driver.findElementByAccessibilityId("Create contact");
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
    public void tearDown() {
        if (null != driver)
            driver.quit();
    }

}
