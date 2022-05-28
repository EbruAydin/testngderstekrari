package tests.day17_pom;

import Pages.HotelMyCampPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class PositiveTest {

    @Test
    public void positiveLoginTest(){
        HotelMyCampPage obj=new HotelMyCampPage();

        //https://www.hotelmycamp.com adresine gidin
        Driver.getDriver().get("https://www.hotelmycamp.com ");

        //login butonuna basin
        obj.loginTusuElementi.click();


        //test data userName:manager
        obj.userName.sendKeys("manager" + Keys.ENTER);


        //test data password:Manager1!
        obj.password.sendKeys("Manager1!" + Keys.ENTER);

        //obj.loginTusuElementi.click();

        //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.

        Actions action=new Actions(Driver.getDriver());
        action.moveToElement(obj.userNameAferLogin).perform();

        Assert.assertTrue(obj.logOutElementi.isDisplayed());

        Driver.closeDriver();

    }
}
