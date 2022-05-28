package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {

    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //login butonuna basin
    @FindBy (linkText = "Log in")
    public WebElement logIn;

    //test data userName:manager
    @FindBy (xpath="//input[@id='UserName']")
    public WebElement userName;

    //test data password:Manager1!
    @FindBy (xpath="//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath="//li[@id='navLogon']")
    public WebElement loginTusuElementi;

    //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.

    @FindBy (xpath="//li[@class='dropdown dropdown-user']")
    public WebElement userNameAferLogin;

    @FindBy (xpath="//a[text()=' Log out ']")
    public WebElement logOutElementi;
}
