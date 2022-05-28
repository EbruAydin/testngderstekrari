package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ReactPage {

    public ReactPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    @FindBy (xpath="//div[@tabindex='1']")
    public WebElement sitedekiUrunler;

// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin


// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın


// (Her ürün 1 defadan fazla eklenemez!)

// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın

// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin

// 7.Checkout'a tıklayın
}
