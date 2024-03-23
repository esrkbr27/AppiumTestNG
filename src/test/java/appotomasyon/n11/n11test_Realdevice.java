package appotomasyon.n11;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class n11test_Realdevice {
    public AppiumDriver driver;

    By kategorilerbtn=By.xpath("(//*[@resource-id='com.dmall.mfandroid:id/navigation_bar_item_icon_view'])[2]");
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
                 //       .setUdid("emulator-5554")
                        .setAppActivity("com.dmall.mfandroid.activity.base.NewSplash")
                        .setPlatformVersion("9.0")
                        .setNoReset(false)
                        .setAutomationName("uiautomator2")
                        .setAppPackage("com.dmall.mfandroid")
                        .setDeviceName("df8cd3cb");


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
     //  driver.findElement(kategorilerbtn).click();

    }

    public void teardown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

