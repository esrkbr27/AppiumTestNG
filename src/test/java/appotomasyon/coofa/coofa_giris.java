package appotomasyon.coofa;

import appotomasyon.Udemyappotomasyon.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.util.List;

public class coofa_giris {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver= CreateDriverSession.coofadriver("GM8");

        List<WebElement> menu= driver.findElements(AppiumBy.className("android.view.ViewGroup"));




    }
}
