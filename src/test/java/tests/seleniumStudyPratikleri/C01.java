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

    ReactPage obj = new ReactPage();

    @Test
    public void test() throws InterruptedException {

        //config ekle !!!
        Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");

        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

        obj.sitedekiUrunler();
        obj.urunAdlari();

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        obj.rastgeleUrunSecme();

    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        obj.urunFiyatToplami();


    // 7.Checkout'a tıklayın
        //obj.checkOut.click();
        obj.aletAccept();

      Driver.closeDriver();
    }
}
/*
Can Hocanin yontemi

    public void Test() throws InterruptedException {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        List<WebElement> urunlerListesiWebElement = driver.findElements(By.xpath("//p[@class='sc-124al1g-4 eeXMBo']"));
        urunYazdir(urunlerListesiWebElement);
        //(//button[@class='sc-124al1g-0 jCsgpZ'])
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        urunAdlariniListeEkle(urunlerListesiWebElement);
        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        randomBesUrunSecSepeteEkleveYazdir(driver);
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        String cartTotalPriceString = driver.findElement(By.xpath("//div[@class='sc-1h98xa9-8 bciIxg']//p[@class='sc-1h98xa9-9 jzywDV']")).getText();
        double actualCartTotalPrice = Double.parseDouble(cartTotalPriceString.replaceAll("\\D", ""));
        double expectedRandomSecilenUrunlerinFiyatToplami = secilenOgelerinFiyatiniTopla(driver);
        Assert.assertEquals(actualCartTotalPrice, expectedRandomSecilenUrunlerinFiyatToplami);
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazdirin
        System.out.println("Test Pass");
        // 7.Checkout'a tıklayın
        driver.findElement(By.xpath("//button[@class='sc-1h98xa9-11 gnXVNU']")).click();
    }
    private double secilenOgelerinFiyatiniTopla(WebDriver driver) {
        double toplam = 0;
        List<WebElement> pricesOfTheProductInTheCart = driver.findElements(By.xpath("//div[@class='sc-11uohgb-4 bnZqjD']//p"));
        for (WebElement each : pricesOfTheProductInTheCart) {
            toplam +=  Double.parseDouble(each.getText().replaceAll("\\D", ""));
        }
        return toplam;
    }
    private void randomBesUrunSecSepeteEkleveYazdir(WebDriver driver) throws InterruptedException {
        Random random = new Random();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        List<WebElement> addToChartWebElementList = driver.findElements(By.xpath("//button[@class='sc-124al1g-0 jCsgpZ']"));
        int count = 0;
        while (count < 5) {
            int randomNum = random.nextInt(addToChartWebElementList.size());
            System.out.println(" secilen random numaralar :" + randomNum);
            jse.executeScript("arguments[0].scrollIntoView();", addToChartWebElementList.get(randomNum));
            addToChartWebElementList.get(randomNum).click();
            Thread.sleep(1000);
            WebElement cartCloseButton = driver.findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
            cartCloseButton.click();
            addToChartWebElementList.remove(randomNum);
            count++;
        }
        WebElement cartOpenButton = driver.findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
        cartOpenButton.click();
        List<WebElement> productsInTheChart = driver.findElements(By.xpath("//p[@class='title']"));
        productsInTheChart.stream().forEach(t -> System.out.println(t.getText()));
    }
    private void urunAdlariniListeEkle(List<WebElement> urunlerListesiWebElement) {
        List<String> urunListesiList = new ArrayList<>();
        for (int i = 0; i < urunlerListesiWebElement.size(); i++) {
            urunListesiList.add(urunlerListesiWebElement.get(i).getText());
        }
    }
    private void urunYazdir(List<WebElement> urunlerListesiWebElement) {
        for (int i = 0; i < urunlerListesiWebElement.size() ; i++) {
            System.out.println(i+1 + ". urun = " + urunlerListesiWebElement.get(i).getText());
        }
    }
}
 */
