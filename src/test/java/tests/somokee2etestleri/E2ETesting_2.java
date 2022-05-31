package tests.somokee2etestleri;

import Pages.HotelMyCampPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class E2ETesting_2 {
    //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
    //2. Bir metod olusturun: RoomCreateTest()
    //3. https://www.hotelmycamp.com adresine gidin.
    //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
    //a. Username : manager b. Password : Manager1!
    //5. Login butonuna tıklayın.
    //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
    //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    //8. Save butonuna basin.
    //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
    //10. OK butonuna tıklayın.
    //11. Hotel rooms linkine tıklayın.
    //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.

    @Test
    public void RoomCreateTest() {

        HotelMyCampPage obj = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        Actions action = new Actions(Driver.getDriver());

        action
                .click(obj.loginTusuElementi)
                .perform();

        action
                .click(obj.userName)
                .sendKeys(ConfigReader.getProperty("htTrueUsername"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("htTruePassword"))
                .sendKeys(Keys.ENTER)
                .perform();

        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        obj.systemManagement.click();
        obj.hotelManagement.click();
        obj.hotelListMenu.click();
        obj.addHotelButonu.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        action
                .click(obj.code)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("Ebru")
                .sendKeys(Keys.TAB)
                .sendKeys("Sweden")
                .sendKeys(Keys.TAB)
                .sendKeys("123456789")
                .sendKeys(Keys.TAB)
                .sendKeys("aydinnebrr@gmail.com")
                .sendKeys(Keys.ENTER)
                .perform();


        //select section
        WebElement dropDown = obj.select;
        Select select = new Select(dropDown);
        select.selectByVisibleText("Hotel Type2");

        //8. Save butonuna tıklayın.
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", obj.saveButton);


        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(obj.basariliKayitText));
        Assert.assertTrue(obj.basariliKayitText.isDisplayed());

        //10. OK butonuna tıklayın
        obj.okButonu.click();

        //11. Hotel rooms linkine tıklayın.
        obj.systemManagement.click();
        obj.hotelManagement.click();
        obj.hotelRoomMenu.click();

        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
        Assert.assertTrue(obj.listOfHotelText.isDisplayed());

        Driver.closeDriver();
    }
}
