package tests.seleniumStudyPratikleri;

import Pages.HotelMyCampPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelNegativeTestConfig {

    /*
    1 ) Bir Class olustur: HotelmycampNegativeTest
    2) Bir test method olustur negativeLoginTest()
          https://www.hotelmycamp.com/ adresine git
          login butonuna bas
          test data username: manager1
          test data password: manager1!
          Degerleri girildiginde sayfaya girilemedigini test et
     */

    @Test
    public void test01() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        HotelMyCampPage obj=new HotelMyCampPage();
        //  https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        //          login butonuna bas
        obj.logIn.click();

        //          test data username: manager1
        //          test data password: manager1!
        //          Degerleri girildiginde sayfaya girilemedigini test et

        Actions action=new Actions(Driver.getDriver());
        action
                .click(obj.userName)
                .sendKeys(ConfigReader.getProperty("htWrongUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("htWrongPassword"))
                .sendKeys(Keys.ENTER)
                .perform();

        //  1.yol
        //  Assert.assertTrue(obj.tryAgainText.isDisplayed(),"hatali veri girisi yapildi");

        //2.yol
        String gercekUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(gercekUrl.equals(ConfigReader.getProperty("hotelUrlBasariliGiris")), "hatali girisi yapilmistir.");
        softAssert.assertAll();

        Driver.closeDriver();
    }
    //soft assert kullan
}
