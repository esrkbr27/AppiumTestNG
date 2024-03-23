package appotomasyon.Udemyappotomasyon;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scroll {




    public static void main(String[] args) throws Exception {

       AppiumDriver driver=CreateDriverSession.initilazedriver("GM8");
       scroll(driver);




    }

    public static void scroll(AppiumDriver driver){

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();
        WebElement element=driver.findElement(AppiumBy.id("android:id/list"));

        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
         //       "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId",((RemoteWebElement)element).getId(),
                "direction", "down",
                "percent", 1.0,
                "speed",5000
        ));
    }



}
