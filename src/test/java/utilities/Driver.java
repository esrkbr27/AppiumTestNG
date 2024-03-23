package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver(){

    }
    private static UiAutomator2Options options;
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("platformName")) {
                case "Android":
                    options = new UiAutomator2Options()
                            .setPlatformVersion(ConfigReader.getProperty("platformVersion"))
                            .setAppPackage(ConfigReader.getProperty("n11Package"))
                            .setAppActivity(ConfigReader.getProperty("n11Activity"))
                            .setDeviceName(ConfigReader.getProperty("deviceName"))
                            .setAutomationName("uiautomator2")
                            .setNoReset(false)
                            .setNewCommandTimeout(Duration.ofMinutes(10));

                    try {
                        driver = new AndroidDriver(

                                new URL("http://127.0.0.1:4723"), options

                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

                case "IOS":
                    //ios ile ilgili konfigurasyonlar buraya...
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

        public static void closeDriver() {
            driver.quit();
        }
    }

