package appotomasyon.Udemyappotomasyon;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class DragAndDrop {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver=CreateDriverSession.initilazedriver("Pixel 5");
        dragAndDrop(driver);

    }

    public static void dragAndDrop(AppiumDriver driver){


        By views = AppiumBy.accessibilityId("Views");
        By draganddrop = AppiumBy.accessibilityId("Drag and Drop");

        driver.findElement(views).click();
        driver.findElement(draganddrop).click();

        /*
        executescript metodu içeirsindeki x , y koordinatları; tutup sürükleyeceğimiz elementin
        koordinatlarıdır.

        metodun içerisindeki elementin locati ise merkezde olan üzerine bırakacağımız
        elementin locateidir.

         */
        WebElement element=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 356,
                "endY", 309
        ));

    }
}
