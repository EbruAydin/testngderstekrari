package day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {

    /*
    dependsOnMethod test methodlarinin calisma siralamasina karismaz
    sadece bagimli olan test baglandigi testin sonucuna bakar
    baglandigi test PASSED olmaz ise baglanan test hic calismaz
    buna da ignore denir

    Bu durumda priority'nin de ayarlanmasi lazim
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.ramazon1.com");

    }
    @Test (dependsOnMethods = "test01")
    public void test02(){
        // Nutella aratalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }
    @Test (dependsOnMethods = "test02")
    public void test03(){
        // Sonuc yazisinin Nutella icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }
}
