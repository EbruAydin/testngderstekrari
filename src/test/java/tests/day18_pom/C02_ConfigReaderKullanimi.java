package tests.day18_pom;

import Pages.FacebookPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {

    // facebook anasayfaya gidin
    // cikarsa cookies kabul edin
    // kullanici mail kutusuna yanlis kullanici isimi yazdirin
    // kullanici sifre kutusuna rastgele bir password yazdirin
    // login butonuna basin
    // giris yapilamadigini test edin
    @Test
    public void test01(){

        FacebookPage obj=new FacebookPage();
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // cikarsa cookies kabul edin
        obj.cookieButonu.click();
        // kullanici mail kutusuna yanlis kullanici isimi yazdirin
        // kullanici sifre kutusuna rastgele bir password yazdirin
        Actions action=new Actions(Driver.getDriver());

        action
                .sendKeys(ConfigReader.getProperty("fbWrongUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("fbWrongPassword"))
                .sendKeys(Keys.ENTER)
                .perform();

        // login butonuna basin
        obj.loginTusu.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(obj.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}
