package appotomasyon.Udemyappotomasyon;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static appotomasyon.coofa.coofa.driver;

public class DefiningElement {

    @AndroidFindBy (xpath = "//*[@text=\"Accessibility\"]")
    private static WebElement accessibility;

    public DefiningElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public static void main(String[] args) throws Exception {

        AppiumDriver driver=CreateDriverSession.initilazedriver("GM8");

        /*

        1.yol:
        PageFactory kullanarak tek parametreli(driver parametreli) constructor oluşturup (class seviyesinde veya ayrı bir classta)
        main metod içinde obje oluşturup elementi çağırıp istediğimiz işlemi yapmak
         */
        DefiningElement definingElement=new DefiningElement(driver);
        System.out.println("accessibility.getText() = " + accessibility.getText());


        /*
        2.yol:
        Accesebility tıklamak için öncelikle By notsyonu ile bir değişkene atadık.
        By notasyonu ile elementleri tanımlamamızın sebebi; loactelerde bir değişiklik olduğu zaman
        kolaylıkla gelip değişiklik yapabilmek içindir.
         */

        By accesebility= AppiumBy.accessibilityId("Accessibility");
        driver.findElement(accesebility).click();
    }
}
