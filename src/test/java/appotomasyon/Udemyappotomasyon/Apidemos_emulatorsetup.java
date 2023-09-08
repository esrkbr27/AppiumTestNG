package appotomasyon.Udemyappotomasyon;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Apidemos_emulatorsetup {

    AppiumDriver driver;

    @BeforeTest
    public void before() {

        if (driver == null) {


            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android")
                        .setUdid("emulator-5554")
                        .setDeviceName("Pixel 5")
                        .setApp("C:/Users/esra.demirci/AppiumTestNG/src/main/resources/Apidemos-debug.apk")
                        .setAutomationName("UiAutomator2")
                        .setNewCommandTimeout(Duration.ofSeconds(3000));







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
    public void test(){

        System.out.println("session id: "+ driver.getSessionId());
    }
}
