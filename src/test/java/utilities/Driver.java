package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    POM Driver icin TestBase class'ina extends etmek yerine
    Driver classindan static methodlar kullanarak
    driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver'in kapatilmasi tercih edilir
     */

    private Driver(){

    }
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

        /*
        bu son asamada artik butun browser'lar icin bir Driver page olusturuyoruz. Asagidaki gibi:
        bunun icin ConfigReader isimli class ve configurarion.properties class'i lazim.
         */

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }


    public static void closeDriver() {

        if (driver != null) {
            driver.close();
            driver = null;//ne olur ne olmaz diyerek eklendi
        }
    }
}
