package tests.day17_pom;

import Pages.HotelMyCampPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class PositiveTest {

    //https://www.hotelmycamp.com adresine gidin
    //login butonuna basin
    //test data userName:manager
    //test data password:Manager1!
    //obj.loginTusuElementi.click();
    //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.
    @Test
    public void positiveLoginTest() {
        HotelMyCampPage obj = new HotelMyCampPage();

        Driver.getDriver().get("https://www.hotelmycamp.com ");

        Actions action = new Actions(Driver.getDriver());
        action
                .click(obj.loginTusuElementi)
                .perform();


        /*
        1.yol
        obj.loginTusuElementi.click();
        obj.userName.sendKeys("manager" + Keys.ENTER);
        obj.password.sendKeys("Manager1!" + Keys.ENTER);
         */

        action.
                click(obj.userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();

        //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.

        action.moveToElement(obj.userNameAferLogin).perform();
        Assert.assertTrue(obj.logOutElementi.isDisplayed());

        Driver.closeDriver();

    }
}
