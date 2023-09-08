package appotomasyon.Udemyappotomasyon;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateDriverSession {



    public static AppiumDriver initilazedriver(String devicename) throws Exception {

        URL url = new URL("http://127.0.0.1:4723");

        switch (devicename) {

            case "GM8":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "df8cd3cb");
                caps.setCapability(MobileCapabilityType.APP, "C:/Users/esra.demirci/AppiumTestNG/src/main/resources/Apidemos-debug.apk");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,devicename);

                return new AndroidDriver(url, caps);

            case "Pixel 5":
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android")
                        .setUdid("emulator-5554")
                        .setDeviceName(devicename)
                        .setApp("C:/Users/esra.demirci/AppiumTestNG/src/main/resources/Apidemos-debug.apk")
                        .setAutomationName("UiAutomator2")
                        .setNewCommandTimeout(Duration.ofSeconds(3000));

                return new AndroidDriver(url,options);

            default: throw new Exception("invalidPlatform");

        }

    }


    public static AppiumDriver coofadriver(String devicename) throws Exception {

        URL url = new URL("http://127.0.0.1:4723");
        UiAutomator2Options options = new UiAutomator2Options();

        switch (devicename) {

            case "Pixel 5":

                options.setPlatformName("Android")
                        .setUdid("emulator-5554")
                        .setDeviceName(devicename)
                        .setApp("C:/Users/esra.demirci/AppiumTestNG/src/main/resources/app-release (1).apk")
                        .setAutomationName("UiAutomator2")
                        .setNewCommandTimeout(Duration.ofSeconds(3000))
                        .setAppPackage("com.bek.mobile.app")
                        .setAppActivity("com.bek.mobile.app.MainActivity")
                        .setPlatformVersion("10.0");

                return new AndroidDriver(url, options);

            case "GM8":

                options.setPlatformName("Android")
                        .setUdid("df8cd3cb")
                        .setDeviceName(devicename)
                        .setApp("C:/Users/esra.demirci/AppiumTestNG/src/main/resources/app-release (1).apk")
                        .setAutomationName("UiAutomator2")
                        .setNewCommandTimeout(Duration.ofSeconds(3000))
                        .setAppPackage("com.bek.mobile.app")
                        .setAppActivity("com.bek.mobile.app.MainActivity")
                        .setPlatformVersion("9.0");


                return new AndroidDriver(url,options);

            default: throw new Exception("invalidPlatform");

        }

    }

}
