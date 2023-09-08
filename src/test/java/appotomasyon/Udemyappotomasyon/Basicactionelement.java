package appotomasyon.Udemyappotomasyon;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import utilities.ReusableMethods;

public class Basicactionelement {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver=CreateDriverSession.initilazedriver("Pixel 5");

        By views= AppiumBy.accessibilityId("Views");
        By textfields=AppiumBy.accessibilityId("TextFields");
        By edittext=AppiumBy.id("io.appium.android.apis:id/edit");

        //Anasayfada views e tıkla
        driver.findElement(views).click();

        //(Swipe)




        //Textfields e tıkla
        driver.findElement(textfields).click();
        driver.findElement(edittext).sendKeys("I am learning Appium");
        ReusableMethods.waitFor(3);
        driver.findElement(edittext).clear();
    }
}
