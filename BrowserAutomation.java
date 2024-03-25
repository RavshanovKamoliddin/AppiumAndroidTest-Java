package Android;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserAutomation {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformname", "Android Emulator");
        capabilities.setCapability("automationName","Uiautomator2");
        capabilities.setCapability("platformversion", "10.0");
        capabilities.setCapability("browserName", "Chrome");

        URL url = URI.create("http://127.0.0.1:4723/").toURL();

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, capabilities);

        driver.get("https://www.google.com/");

        //find search box web element
        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("Taj mahal");
        searchBox.sendKeys(Keys.RETURN);

        Thread.sleep(3000);
        driver.quit();

    }

}
