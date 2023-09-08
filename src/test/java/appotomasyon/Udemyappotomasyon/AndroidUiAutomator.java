package appotomasyon.Udemyappotomasyon;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AndroidUiAutomator {

    public static void main(String[] args) throws Exception {

      AppiumDriver driver=CreateDriverSession.initilazedriver("Pixel 5");



      /*UiAutomator ile locate alma sadece native uygulamalarda olur.Hangi argumanetlerle nasıl locate alacagımzı
      "https://developer.android.com/reference/android/support/test/uiautomator/UiSelector" adresinden faydalanarak bulabiliriz.

      * UIAutomator ile iki farklı yöntemle elementi tanımlayabiliriz.
      Biri WebElement ile diğeri de By ile yapılabilir.Aşağıda UiSelector kullanarak text değeri "Accessibility" olan
      elementi bul ve gettext() ile bu elementin textini yazdır dedik,


      */
        WebElement myelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        By element=AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")");
        System.out.println(myelement.getText());

        /*className metodu ile de class değeri "android.widget.TextView" olan elementi bul getText() ile
        bu elementin textini yazdır deyince bize class değeri verilen ilk elementin ("API Demos")
        textini verdi.Biz "Accessibility"e ulaşmak istediğimiz için class değeri verilen elementleri liste atıp
        index ile o elemente ulaşabiliriz.index değeri 2

        */
        myelement=driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(myelement.getText());


        //description ile elementi bulmak için; inspectordeki "content-desc" değerini kullanırız.
        myelement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println(myelement.getText());

        //resource id değerini yazdık.
        myelement=driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
        System.out.println(myelement.getText());

      // WebElement accessibility= driver.findElement(AppiumBy.accessibilityId("Accessibility"));
      // System.out.println("accesebility : "+accessibility.getText());

      // //resource id ile 12 tane element olduğu görüldü.Bizim aradığımızın index:1 olduğu için index ile unique hale getirildi.
      // WebElement accessibility1= driver.findElements(AppiumBy.id("android:id/text1")).get(1);
      // System.out.println("resource-id: "+ accessibility1.getText());

      // WebElement accessibility2= driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
      // System.out.println("classname "+ accessibility2.getText());

      // WebElement accessibility3= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));

      // WebElement accessibility4= driver.findElement(AppiumBy.name("Accessibility"));










    }
    }

