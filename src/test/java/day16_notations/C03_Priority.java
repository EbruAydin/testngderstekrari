package day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    TestNg test methodlarini isim sirasina gore calistirir
    eger isim siralamasi disinda bir siralama ile calismasini isterseniz
    o zaman test methodlarina oncelik vermeniz gerekir

    priority kucukten buyuge gore calisir
    eger bir test methodunda priority degeri atanmamis ise
    default olarak 0 degeri alir

    -5 desen o en kucuk olur mesela
     */
    @Test (priority = -5)
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test(priority = -2)
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void teachProTesti() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}
