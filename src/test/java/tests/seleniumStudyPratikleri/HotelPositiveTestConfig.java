package tests.seleniumStudyPratikleri;

import Pages.HotelMyCampPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static org.openqa.selenium.Keys.TAB;

public class HotelPositiveTestConfig {
    //https://www.hotelmycamp.com adresine gidin
    //login butonuna basin
    //test data userName:manager
    //test data password:Manager1!
    //obj.loginTusuElementi.click();
    //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.


    @Test
    public void test01() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //1.adim ilgili page sayfasindan obje olustur daha sonra task yapmaya gecersin
        HotelMyCampPage obj=new HotelMyCampPage();

        //https://www.hotelmycamp.com adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        //login butonuna basin
        obj.loginTusuElementi.click();

        //test data userName:manager
        //test data password:Manager1!
       Actions action=new Actions(Driver.getDriver());
        action
                .click(obj.userName)
                .sendKeys(ConfigReader.getProperty("htTrueUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("htTruePassword"))
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(5000);
        //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.

        /*
        String gercekUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(gercekUrl,ConfigReader.getProperty("hotelUrlBasariliGiris"));
        softAssert.assertTrue(gercekUrl.equals(ConfigReader.getProperty("hotelUrlBasariliGiris")), "hatali girisi yapilmistir.");
        softAssert.assertAll();
         */
        action.moveToElement(obj.userNameAferLogin).perform();
        Assert.assertTrue(obj.logOutElementi.isDisplayed(),"basariyla gecti");

        Driver.closeDriver();

    }

}
