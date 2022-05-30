package tests.somokee2etestleri;

import Pages.HotelMyCampPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.ObjectInputFilter;

public class HotelMyCampPositiveTest {

    @Test
    public void test01(){
        HotelMyCampPage obj=new HotelMyCampPage();

        //https://www.hotelmycamp.com adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        Actions action=new Actions(Driver.getDriver());

        //login butonuna basin
        action
                .click(obj.loginTusuElementi)
                .perform();

        //test data userName:manager
        //test data password:Manager1!

        action
                .click(obj.userName)
                .sendKeys(ConfigReader.getProperty("htTrueUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("htTruePassword"))
                .sendKeys(Keys.ENTER)
                .perform();

        //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.

        action.
                moveToElement(obj.userNameAferLogin)
                .perform();

        Assert.assertTrue(obj.logOutElementi.isDisplayed());

        Driver.closeDriver();
    }
}
