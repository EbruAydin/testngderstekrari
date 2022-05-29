package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReactPage {

    static List<String> rastgeleSecilenUrunIsimleri = new ArrayList<>();
    static List<String> eklenenUrunler = new ArrayList<>();
    static List<String> urunlerinAdi = new ArrayList<>();
    static List<String> urunFiyati = new ArrayList<>();
    static List<Integer> urunFiyatiInt = new ArrayList<>();

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

    @FindBy(xpath = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement checkOut;


// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin

    public List<String> urunAdlari() {

        List<String> urunlerinAdi = new ArrayList<>();
        for (WebElement each : urunIsimleri) {
            urunlerinAdi.add(each.getText());
            System.out.println("Urunlerim Isimleri : " + each.getText());
        }

        return urunlerinAdi;
    }


    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

    public List<String> sitedekiUrunler() {
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
        Random rnd = new Random();

        do {
            int randomIndex = rnd.nextInt(16);
            if (!eklenenUrunler.contains(sitedekiUrunler.get(randomIndex).getText())) {
                jse.executeScript("arguments[0].click();", addToChartButton.get(randomIndex));
                eklenenUrunler.add(sitedekiUrunler.get(randomIndex).getText());
            }
            if (!urunlerinAdi.contains(urunIsimleri.get(randomIndex).getText())) {
                urunlerinAdi.add(urunIsimleri.get(randomIndex).getText());
            }
            if (!urunFiyati.contains(urunFiyatlari.get(randomIndex).getText())) {
                urunFiyati.add(urunFiyatlari.get(randomIndex).getText());
            }
        } while (eklenenUrunler.size() < 5);
        System.out.println(eklenenUrunler);
        System.out.println("urun Fiyatlari : " + urunFiyati);

        return rastgeleSecilenUrunIsimleri;
    }

    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın

    public int urunFiyatToplami() {

        List<String> sepettekiUrunler = new ArrayList<>();
        int toplam = 0;
        for (int i = 0; i < 5; i++) {
            sepettekiUrunler.add(urunFiyati.get(i).replaceAll("\\D", ""));
            urunFiyatiInt.add(Integer.valueOf(sepettekiUrunler.get(i)));
            toplam+=urunFiyatiInt.get(i);
        }

        String sepetFiyat = sepetTotalPrice.getText().replaceAll("\\D", "");
        int spetFiyatiInt = Integer.parseInt(sepetFiyat);

        System.out.println("sepet int fiyati : " + spetFiyatiInt);
        System.out.println("sceilen urunlerin toplam degeri : " + "$" + toplam);

        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        Assert.assertEquals(toplam, spetFiyatiInt);

        return toplam;
    }

// 7.Checkout'a tıklayın

    public void aletAccept() {
        checkOut.click();
        Driver.getDriver().switchTo().alert().accept();
    }
}

