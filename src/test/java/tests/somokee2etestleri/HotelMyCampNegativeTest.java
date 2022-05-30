package tests.somokee2etestleri;

import Pages.HotelMyCampPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCampNegativeTest {

    @Test
    public void test01(){
        HotelMyCampPage obj=new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        Actions action=new Actions(Driver.getDriver());
         /*
    1 ) Bir Class olustur: HotelmycampNegativeTest
    2) Bir test method olustur negativeLoginTest()
          https://www.hotelmycamp.com/ adresine git
          login butonuna bas
          test data username: manager1
          test data password: manager1!
          Degerleri girildiginde sayfaya girilemedigini test et
     */

        action
                .click(obj.loginTusuElementi)
                .perform();

        action
                .click(obj.userName)
                .sendKeys(ConfigReader.getProperty("htWrongUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("htWrongPassword"))
                .sendKeys(Keys.ENTER)
                .perform();

        Assert.assertTrue(obj.tryAgainText.isDisplayed());
        Driver.closeDriver();
    }
}
