package appotomasyon.Udemyappotomasyon;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Swipe {

    /*
    1.yol:Plugin yüklemeden swipe yapmak için şu sayfaya gidilir: "https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md"
    Bu sayfada yer alan swipe bölümündeki kod bloğu kopyalanır.Bu sayfada yer alan swipe() metodu bunu çalıştırır.
    Koordinatlarla eğer swipe yapamıyorsa;
    elementId parametre olrak eklenir ve elementId ile swipe yapılır.element olarak ya kaydıracağımız elementin id değeri
    elemente atanır.Eğer elementin specific bir id değeri yoksa o zaman kaydırma yapacağımız sınırlı alanı(bounding area)
    içine alan bir id değeri atanır.Verilen github sayfasında "speed" değeri zorunlu olmadığı için ilk önce parametre olarak eklenmedi
    fakat kod çalışmayıp hata mesajı okunduğunda "speed" değerinin eksik olduğu yazıyordu.Bu nedenle biz de speed değerini
    default olarak "5000" olarak ekledik ve kodumuz bu şekilde çalıştı sayfanın sonuna kadar swipe yaptı.
    Neden sonuna kadar? çünkü veridğimiz id değeri orarda yer alan tüm lelementleri kapsayan bir list id değeri olduğu için

    2.yol:Appium2.0 ile birlikte swipe scroll hareketlerini plugin yükleyerek daha kolay ve daha az kod ile yapabiliriz
    Bunun için "https://github.com/AppiumTestDistribution/appium-gestures-plugin#readme" adresindeki install kodu ile
    birlikte plugin yüklenir.Bu sayfada yer alan swipe bölümünde ilgili kod bloğu yer alır.
    Ardından verilen kod bloğu kopyalanır.Bu sayfada yer alan swipewithplugin() metodu
    plugin ile çalıştırmak için yazılan kod bloğudur.

    -Plugini yüklemek için şu komut çalıştırılır: appium plugin install --source=npm appium-gestures-plugin
    -Plugin ile serverı çalıştırmak için; appium --use-plugins=gestures komutu çalıştırılır.daha sonra kod çalıştırılır.



    */

    public static void main(String[] args) throws Exception {

        AppiumDriver driver=CreateDriverSession.initilazedriver("Pixel 5");
        swipewithplugin(driver);


    }

    public static void swipe(AppiumDriver driver){


        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

      //Udemyde verilen yöntem aşağıdaki gibidir.(plugin yüklemeden)

             WebElement element=driver.findElement(AppiumBy.id("android:id/list"));
             driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
              // "left", 100, "top", 100, "width", 600, "height", 600,
              "elementId", ((RemoteWebElement)element).getId(),"direction", "up","percent", 0.75,
                     "speed",5000
      ));






    }


    public static void swipewithplugin(AppiumDriver driver){

        //Plugin yükleyerek


        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        RemoteWebElement element = (RemoteWebElement) wait.until(presenceOfElementLocated(AppiumBy.id("android:id/list")));
        driver.executeScript("gesture: swipe", Map.of("elementId", element.getId(), "percentage", 50, "direction", "up"));


    }
}
