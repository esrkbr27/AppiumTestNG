package appotomasyon.Udemyappotomasyon;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

import java.util.List;

public class ApiDemoFindElements {

   public static void main(String[] args) throws Exception {

           /*           LOCATOR STRATEJİLERİ

        *Native android cihazlar 4 türlü locati destekler:
          -Accesibilty id
          -ClassName
          -Xpath
          -UiSelector

        *Accessibiltyid var ise bu uniqe değer alır ,fakat resource-id unique değildir.Resource-id ile locate
        alırken liste atıp index ile unique olarak alabiliriz.Hangi inex de olduğunu inspectordeki index: karşısında
        yazan değerden öğrenebiliriz.

        *Native uygulamalarda name ile locate alırken name değeri olarak android inspectordeki text karşılığındaki value yazılır.


        *Tagname ile locate alırken android inspectordeki content-desc attributunun valuesu yazılır.
        Android native uygulamalarda tagname ile loacte alınamaz.

        *Uiselector ile locate almak için şu adresten faydalanılabilir;
        "https://developer.android.com/reference/android/support/test/uiautomator/UiSelector"


*/


       AppiumDriver driver=CreateDriverSession.initilazedriver("Pixel 5");

        WebElement accessibility= driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("accesebility : "+accessibility.getText());

        //resource id ile 12 tane element olduğu görüldü.Bizim aradığımızın index:1 olduğu için index ile unique hale getirildi.
        WebElement accessibility1= driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("resource-id: "+ accessibility1.getText());

        WebElement accessibility2= driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("classname "+ accessibility2.getText());

        WebElement accessibility3= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));

        WebElement accessibility4= driver.findElement(AppiumBy.name("Accessibility"));

        //tagname i desteklemiyor
        WebElement accessibility5=driver.findElement(AppiumBy.tagName("Accessibility"));








    }




    }

