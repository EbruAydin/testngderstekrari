package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReactPage {


    static List<String> rastgeleSecilenUrunIsimleri = new ArrayList<>();
    static List<String> eklenenUrunler = new ArrayList<>();
    static List<String> urunFiyati = new ArrayList<>();
    static List<Integer> urunFiyatiInt = new ArrayList<>();

    static String sepetFiyat ="";
    static int sepetFiyatiInt =0;
    static int toplam=0;

    public ReactPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    @FindBy(xpath = "//div[@tabindex='1']")
    public List<WebElement> sitedekiUrunler;

    @FindBy(xpath = "//p[@class='sc-124al1g-4 eeXMBo']")
    public List<WebElement> urunIsimleri;

    @FindBy(xpath = "//button[text()='Add to cart']")
    public List<WebElement> addToChartButton;

    @FindBy(xpath = "//p[@class='sc-124al1g-6 ljgnQL']")
    public List<WebElement> urunFiyatlari;

    @FindBy(xpath = "//p[@class='sc-1h98xa9-9 jzywDV']")
    public WebElement sepetTotalPrice;

    @FindBy (xpath="//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement checkOut;


// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin

    public List<String> urunAdlari() {

        List<String> urunlerinAdi = new ArrayList<>(Arrays.asList());
        for (WebElement each : urunIsimleri) {
            urunlerinAdi.add(each.getText());
        }
        return urunlerinAdi;
    }


    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

    public List<String> sitedekiUrunler(){
        List<String> tumUrunListesi = new ArrayList<>();

        for (int i = 1; i < sitedekiUrunler.size(); i++) {
            tumUrunListesi.add(sitedekiUrunler.get(i).getText());
            System.out.println(i + ". urun : ");
        }
        return tumUrunListesi;
    }

    // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
    public List<String> rastgeleUrunSecme() throws InterruptedException {

        //random kullanarak bir aralik belirleyecegimiz icin sonrasinda size'i eklemeliyiz burada
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 6; i++) {
            jse.executeScript("arguments[0].click();", addToChartButton.get(i));
            eklenenUrunler.add(sitedekiUrunler.get(i).getText());
        }

        for (int i = 0; i < 6; i++) {
            if (eklenenUrunler.get(i).contains(urunIsimleri.get(i).getText())) {
                rastgeleSecilenUrunIsimleri.add(urunIsimleri.get(i).getText());
            }
        }
        return rastgeleSecilenUrunIsimleri;

    }

    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
    public int urunFiyatToplami() {

        for (int i = 0; i < 6; i++) {
            if (sitedekiUrunler.get(i).getText().contains(urunFiyatlari.get(i).getText())) {
                urunFiyati.add(urunFiyatlari.get(i).getText());
            }
        }

        List<String> sepettekiUrunler = new ArrayList<>();

        for (int i = 0; i < urunFiyati.size(); i++) {
            sepettekiUrunler.add(urunFiyati.get(i).replaceAll("\\D", ""));
        }
        System.out.println(sepettekiUrunler);


        for (int i = 0; i < urunFiyati.size(); i++) {
            urunFiyatiInt.add(Integer.valueOf(sepettekiUrunler.get(i)));
        }

        int toplam = urunFiyatiInt.get(0) + urunFiyatiInt.get(1) + urunFiyatiInt.get(2) + urunFiyatiInt.get(3) +
                urunFiyatiInt.get(4) + urunFiyatiInt.get(5);

        String sepetFiyat = sepetTotalPrice.getText().replaceAll("\\D", "");
        int sepetFiyatiInt = Integer.parseInt(sepetFiyat);

        return toplam;
    }


    // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin

    public void sepetKiyasi(){

        if(sepetFiyatiInt==toplam){
            System.out.println("Test pass");
        } else System.out.println("hatali karsilastirma");
    }

// 7.Checkout'a tıklayın

}
