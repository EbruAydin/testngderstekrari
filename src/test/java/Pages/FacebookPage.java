package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //kullanici mail kutusuna rast gele bir isim yazdirin
    @FindBy(id = "email")
    public WebElement emailKutusu;

    //kullanici sifre kutusuna rast gele bir password yazdirin
    @FindBy(id = "pass")
    public WebElement sifreKutusu;

    //login butonuna basin
    @FindBy(name = "login")
    public WebElement loginTusu;

    //giris yapilamadigini test edin
    @FindBy(className = "_9ay7")
    public WebElement girilemediYaziElementi;


    //cookie butonu
    @FindBy (xpath = "//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")
    public WebElement cookieButonu;
}
