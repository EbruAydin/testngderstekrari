package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {


    /*
       Bugune kadar TestBase classina extends ederek kullandigimiz
       driver yerine bundan sonra Driver class'indan kullanacagimiz getDriver static
       method'unu kullanacagiz

       Driver.getDriver() ---->IN
       driver----------->OUT
        */

    @Test
    public void test01() {

        Driver.getDriver().get("https://www.amazon.com");

        Driver.closeDriver();

        Driver.getDriver().get("https://www.facebook.com");
        Driver.getDriver().get("https://www.bestbuy.com");

        Driver.closeDriver();
        /*
        bu sekilde class uzerinde cagirdigimizda methodu istedigimiz yerde
        call edebiliriz. Mesela amazon'a gider, ardindan kapatir. Daha sonrasinda
        facebook ve bestbuy'a gider ve onlari actiktan sonra kapatir.
         */

    }
}
