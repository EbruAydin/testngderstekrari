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


    @FindBy (xpath="//div[@class='validation-summary-errors']")
    public WebElement tryAgainText;

    //6. Hotel Management/Hotel List menusunden

    @FindBy (xpath="(//li[@class='start open'])[1]")
    public WebElement systemManagement;

    @FindBy (xpath="//*[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy (xpath="(//li//ul//li)[5]")
    public WebElement hotelListMenu;

    @FindBy (xpath="(//li//ul//li)[6]")
    public WebElement hotelRoomMenu;

    @FindBy (xpath="(//*[text()='List Of Hotelrooms'])[2]")
    public WebElement listOfHotelText;

    //ADD HOTEL butonuna tiklayin
    @FindBy (xpath="//*[text()='Add Hotel ']")
    public WebElement addHotelButonu;

    //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    @FindBy (xpath="//input[@name='Code']")
    public WebElement code;

    @FindBy (xpath = "//select[@id='IDGroup']")
    public WebElement select;

    //8. Save butonuna tıklayın.

    @FindBy (xpath="//button[@id='btnSubmit']")
    public WebElement saveButton;

    //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
    @FindBy (xpath="//div[@class='bootbox-body']")
    public WebElement basariliKayitText;

    @FindBy (xpath="(//button[@type='button'])[6]")
    public WebElement okButonu;


}
/*
    @FindBy (xpath="//input[@name='Name']")
    public WebElement name;

    @FindBy (xpath="//input[@name='Address']")
    public WebElement address;

    @FindBy (xpath="//input[@name='Phone']")
    public WebElement phone;

    @FindBy (xpath="//input[@name='Email']")
    public WebElement email;

    @FindBy (xpath="(//select//option)[2]")
    public WebElement options;

     */