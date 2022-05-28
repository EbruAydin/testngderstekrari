package tests.day17_pom;

import Pages.FacebookPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_PageClassKullanimi {

    //facebook anasayfaya gidin
    //cookieleri kabul edin
    //kullanici mail kutusuna rast gele bir isim yazdirin
    //kullanici sifre kutusuna rast gele bir password yazdirin
    //login butonuna basin
    //giris yapilamadigini test edin

    @Test
    public void test() {
        FacebookPage facebook = new FacebookPage();

        //facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");

        //cookieleri kabul edin
        facebook.cookieButonu.click();

        //kullanici mail kutusuna rast gele bir isim yazdirin
        Faker faker = new Faker();
        facebook.emailKutusu.sendKeys(faker.internet().emailAddress());

        //kullanici sifre kutusuna rast gele bir password yazdirin
        facebook.sifreKutusu.sendKeys(faker.internet().password());

        //login butonuna basin
        facebook.loginTusu.click();

        //giris yapilamadigini test edin

        Assert.assertTrue(facebook.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();
    }

}
