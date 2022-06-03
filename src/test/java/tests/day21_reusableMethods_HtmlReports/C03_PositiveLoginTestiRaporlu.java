package tests.day21_reusableMethods_HtmlReports;

import Pages.HotelMyCampPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {
    /*
        Driver obj=new Driver();
        obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        Driver constructor'i private yaptigimiz icin buna artik gerek kalmadi
        cunku hata verir. obje uretilemez zaten ki amacimiz bu, yani obje uretimini engellemek
         */
    HotelMyCampPage obj=new HotelMyCampPage();
    @Test
    public void test01(){

        //extentTest TestBaseRapor icerisinde deger atanmamis bir obje. Atamasini burada yapiyoruz:
        extentTest=extentReports.createTest("Pozitif Login", "Gecerli username ve sifre ile giris " +
                "yapabilmeli");

        //bundan sonraki adimlari bilgi verilmesini istedigim her adimda yazmak durumundayim.
        // Bu bilgiler raporumda gorunecek. Ornek:

        //https://www.hotelmycamp.com adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        extentTest.info("Hotel Sitesinin ana sayfasina gittim.");

        Actions action=new Actions(Driver.getDriver());


        //login butonuna basin
        action
                .click(obj.loginTusuElementi)
                .perform();

        extentTest.info("Log in butonuna tiklandi");

        //test data userName:manager
        //test data password:Manager1!

        action
                .click(obj.userName)
                .sendKeys(ConfigReader.getProperty("htTrueUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("htTruePassword"))
                .sendKeys(Keys.ENTER)
                .perform();
        extentTest.info("Gecerli kullanici adini ve sifreyi girdi.");
        //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.

        action.
                moveToElement(obj.userNameAferLogin)
                .perform();

        extentTest.info("giris yapildiktan sonra kullanici adina tiklandi.");
        Assert.assertTrue(obj.logOutElementi.isDisplayed());
        extentTest.pass("kullanici basarili sekilde giris yapti.");
        Driver.closeDriver();
    }
}
