package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    /*
    POM Driver icin TestBase class'ina extends etmek yerine
    Driver classindan static methodlar kullanarak
    driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver'in kapatilmasi tercih edilir
     */

    static WebDriver driver;

    public static WebDriver getDriver() {//baska bir class'a bir seyi goturebilmesi icin return etmesi gerekir methodun

        /*
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        bu ilk adim olarak olusturduk ama bu sekilde kalirsa her defasinda yeni bir ChromeDriver
        olusturur new ChromeDriver()'dan oturu. Bunun onune gecmek icin de bir sonraki islemleri yapiyoruz
         */

        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver=null;
        }
    }

}
