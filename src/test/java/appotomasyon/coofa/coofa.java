package appotomasyon;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class coofa {
   public static AppiumDriver driver;

    @BeforeTest
    public void before(){

        if (driver == null) {


            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android")
                        .setUdid("emulator-5554")
                        .setAppActivity("com.bek.mobile.app.MainActivity - Coofa")
                        .setPlatformVersion("10.0")
                        .setNoReset(false)
                        .setAutomationName("uiautomator2")
                        .setAppPackage("com.bek.mobile.app")
                        .setDeviceName("Pixel 4");


                driver = new AndroidDriver(

                        new URL("http://127.0.0.1:4723"), options

                );

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    }

    @Test
    public void test() throws InterruptedException {

        WebElement coofa=driver.findElement(By.xpath("(//*[@class='android.view.View'])[4]"));
        Thread.sleep(5);
        coofa.click();
        Thread.sleep(30);


    //    driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup'])[1]")).click();

            WebElement girisikon= driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup'])[5]"));

            ReusableMethods.clickJS(girisikon);
            Thread.sleep(15);








    }

    @AfterTest
    public void teardown(){


    }
}
