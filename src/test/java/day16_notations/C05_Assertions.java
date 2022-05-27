package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {

    @Test
    public void test01(){

        //amazona gidin
        driver.get("https://www.amazon.com");
        //tittl'in amazon icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        //aramasonucna nutella yazdirip aratin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama yapildigini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath(" //div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

        //arama sonucunun Nutella icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("Kutella"));//hata verdirecek


    }

}
