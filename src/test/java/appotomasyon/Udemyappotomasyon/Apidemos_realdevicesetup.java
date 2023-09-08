package appotomasyon.Udemyappotomasyon;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Apidemos_realdevicesetup {

    AppiumDriver driver;

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

            udid : cmd ekranına adb devices yazınca bağlı cihazın udid değerini verir.

             */

            try {

                DesiredCapabilities caps=new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Anroid");
                caps.setCapability(MobileCapabilityType.UDID,"df8cd3cb");
                caps.setCapability(MobileCapabilityType.APP,"C:/Users/esra.demirci/AppiumTestNG/src/main/resources/Apidemos-debug.apk");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"GM8");
                caps.setCapability("newCommandTimeout",3000);




                driver = new AndroidDriver(

                        new URL("http://127.0.0.1:4723"),caps

                );

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    }

    @Test
    public void firsttest(){

        System.out.println("session id"+ driver.getSessionId());

    }

}
