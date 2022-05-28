package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    @Test
    public void test01(){

        /*
        Softassertion baslangic ve bitis satirlari arasindaki
        tum assertionlari yapip
        bitis sirasina geldiginde bize buldugu tum hatalari rapor eder

        bunu da obje olusturarak yapariz
         */

        SoftAssert softAssert = new SoftAssert();
        //amazona gidin
        driver.get("https://www.amazon.com");
        //tittl'in amazon icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title Amazon icermiyor");

        //Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(), "arama kutusuna erisilemiyor");

        //aramasonucna nutella yazdirip aratin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama yapildigini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath(" //div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(), "arama yapilamadi");

        //arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Kutella"),"sonuc yazisi Kutella icermiyor");//hata verdirecek


        //softassert'e bitis satirini soylemek icin assertAll() kullanilir
        //bu satir yazilmazsa assertion gorevi yapilmamis olur
        softAssert.assertAll();

        System.out.println("assert'lerde fail varsa kod buraya kadar inip bunu yazdirmaz.");
        //sout icindeki yaziyi ancak butun assertler true olursa gororuz yani classin sonuna kadar
        //calisir bu durumda

    }

}
