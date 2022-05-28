package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
    Page yapinca hemen CONSTRUCTOR!!! olustururuz ASLA vakit kaybetme
    buradaki this ifadesi bizim java'da kullandigimiz this. islevini goruyor

   Burada webUzerindeki jUnit ile yaptigimiz gorevleri yapiyoruz
    findElement() burada yerini @FindBy'a birakiyor

     */

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        //burada Driver'classindaki getDriver methodunu cagirmis oluyoruz
        //constructor yaparken java'da nasil ki this. ile method ya da obje
        //cagiriyor idiysek. buradaki this de bir anlamda o gorevi goruyor.
    }


    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucuElementi;
}
