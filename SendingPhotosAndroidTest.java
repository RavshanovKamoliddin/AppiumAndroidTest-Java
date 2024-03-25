package Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SendingPhotosAndroidTest {

    public AndroidDriver <MobileElement> driver;

    private static By backupBtn = By.xpath("//android.widget.TextView[@content-desc=\"Photos, has 1 notification\"]");
    private static By touchOutsideBtn = By.id("com.google.android.apps.photos:id/tab_library");
    File callPath, imageDir, img;
    private By photo;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackages", "com.google.android.apps.photos.home.HomeActivity");
        capabilities.setCapability("appActivity", ".home.HomeActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void sendPhoto() throws IOException {

        File classPath = new File(System.getProperty("C:\\Users\\kamoliddin\\AppiumFirstTestAndroid\\src\\main\\resources"));
        imageDir = new File(classPath, "\\resources");
        img = new File(imageDir.getCanonicalFile(), "carbon.png");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(backupBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(touchOutsideBtn)).click();
       // wait.until(ExpectedConditions.presenceOfElementLocated(keepOffBtn)).click();

        String Android_Photo_Path = "C:\\Users\\kamoliddin\\Downloads>";
        driver.pushFile(Android_Photo_Path + "/" + img.getName(), img);
        wait.until(ExpectedConditions.numberOfElementsToBe(photo, 1));
    }


    @AfterTest
    public void tearDown()
    {
        if (null != driver) {
            driver.quit();
        }
    }
}
