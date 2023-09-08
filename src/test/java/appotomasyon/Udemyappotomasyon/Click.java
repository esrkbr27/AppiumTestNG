package appotomasyon.Udemyappotomasyon;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class Click {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver=CreateDriverSession.initilazedriver("Pixel 5");
        click(driver);

    }

    public static void click(AppiumDriver driver){

        WebElement element=driver.findElement(AppiumBy.accessibilityId("Views"));

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }
}
