package appotomasyon.n11;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class n11test_emltr {
    public AppiumDriver driver;

    By kategorilerbtn=By.xpath("(//*[@resource-id='com.dmall.mfandroid:id/navigation_bar_item_icon_view'])[2]");
    By elektronicbtn=By.xpath("(//*[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'])[2]");
    By bilgisayaroption=By.xpath("(//*[@resource-id='com.dmall.mfandroid:id/ivCategoryItem'])[2]");

    @BeforeTest
    public void before() {

        if (driver == null) {
            /*
            Bu classta gercek cihaza bağlanmak için emülatör olmadığı için,
            setUdid ayarını yoruma aldık.Gercek cihazı tanımak için deviceName kısmına
            cihazın vysorda ilk görünen ismini yazdık.Cihazımız 9.0 versiyonunda olduğu için
            versiyonu 9.0 olarak yazdık.

            NOT:Bu bilgiler cihazdan cihaza değişeceği için bağladığımız cihazın vysorda çıkan ismi
            ve versiyonuda değişecektir.

             */

            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android")
                        .setUdid("emulator-5554")
                        .setAppActivity("com.dmall.mfandroid.activity.base.NewSplash")
                        .setPlatformVersion("10.0")
                        .setNoReset(false)
                        .setAutomationName("uiautomator2")
                        .setAppPackage("com.dmall.mfandroid");



                driver = new AndroidDriver(

                        new URL("http://127.0.0.1:4723"), options

                );

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    }

    @Test
    public void test() {
        //Anasayfada Kategoriler butonuna tıkla
       driver.findElement(kategorilerbtn).click();
       //Açılan sayfada elektronik sekmesine tıkla
       driver.findElement(elektronicbtn).click();
       //Açılan sayfada bilgisayar sekmesine tıkla
       driver.findElement(bilgisayaroption).click();
       //Sayfada açılan bilgisayarların göründüğünü doğrula
        List<WebElement> items=driver.findElements(By.id("com.dmall.mfandroid:id/ivCategoryItem"));
        for (WebElement e:items) {
            Assert.assertTrue(e.isDisplayed());

        }

    }

    public void teardown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

