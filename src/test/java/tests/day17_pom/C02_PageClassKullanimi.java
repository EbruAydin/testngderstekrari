package tests.day17_pom;

import Pages.AmazonPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C02_PageClassKullanimi {


    @Test
    public void test(){

        AmazonPage amazon=new AmazonPage();
        //amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // nutella aratalim
        /*
        burada AmazonPage'deki methodlari kullanmak istiyoruz ama o methodlar
        static degil aralarinda extend iliski de yok bu durumda
        bu sayfada AmazonPage kullanarak obje olusturmamiz gerekir ki
        boylece oradaki methodlari cagirabilelim
         */
        amazon.aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        //sonuc yazisi nutella icerdigini test edelim
        String actualSonucYazisi=amazon.aramaSonucuElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains("nutella"));

        Driver.closeDriver();
    }
}
