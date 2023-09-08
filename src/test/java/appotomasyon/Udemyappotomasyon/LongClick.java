package appotomasyon.Udemyappotomasyon;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class LongClick {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initilazedriver("Pixel 5");

        longClickGesture(driver);

    }

    public static void longClickGesture(AppiumDriver driver) {

        By views = AppiumBy.accessibilityId("Views");
        By draganddrop = AppiumBy.accessibilityId("Drag and Drop");

        driver.findElement(views).click();
        driver.findElement(draganddrop).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //long click metodunu "https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md"
        //adresindeki mobile gestures alanından alabiliriz.Biz bu metottaki (Javascript executer castini kaldırıp çalıştırdık.)

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 1000,
                "x", 116,
                "y", 305));

    }
}
