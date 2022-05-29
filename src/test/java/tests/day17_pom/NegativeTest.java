package tests.day17_pom;

import Pages.HotelMyCampPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class NegativeTest {
    /*
    1 ) Bir Class olustur: HotelmycampNegativeTest
    2) Bir test method olustur negativeLoginTest()
          https://www.hotelmycamp.com/ adresine git
          login butonuna bas
          test data username: manager1
          test data password: manager1!
          Degerleri girildiginde sayfaya girilemedigini test et
     */

    @Test
    public void negativeLoginTest() {
        HotelMyCampPage obj = new HotelMyCampPage();
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        obj.loginTusuElementi.click();

        Actions action=new Actions(Driver.getDriver());

        action.
                click(obj.userName)
                .sendKeys("manager1")
                .sendKeys(Keys.TAB)
                .sendKeys("manager1!")
                .sendKeys(Keys.ENTER)
                .perform();

        Assert.assertTrue(obj.tryAgainText.isDisplayed());

    }
}
