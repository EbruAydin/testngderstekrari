package tests.seleniumStudyPratikleri;

import Pages.ReactPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C01 {

    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
// 7.Checkout'a tıklayın

    @Test
    public void test() throws InterruptedException {

        ReactPage obj = new ReactPage();

        Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

        obj.sitedekiUrunler();

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
    // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
    // (Her ürün 1 defadan fazla eklenemez!)
        obj.rastgeleUrunSecme();

    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın

        System.out.println("$"+obj.urunFiyatToplami());
    // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin

        obj.sepetKiyasi();
    // 7.Checkout'a tıklayın
        obj.checkOut.click();

       Driver.closeDriver();
    }

}
