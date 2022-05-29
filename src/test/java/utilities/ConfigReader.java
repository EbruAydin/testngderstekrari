package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

//target icerisinde file koyuyoruz burada isim onemli olmasa da
    //uzantisi onemlidir. mesela .properities gibi

    //bu class bize url ile ilgili gerekli datalari getirir


    public static Properties properties;

    static{
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);//fis dosyayolunu tanimladigimiz configuration.properties
            //dosyasini okudu
            properties=new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yukledi
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        burada kirmizi cizdi altini yani ya yoksa ihtimaline karsi. Eger Throws yaparsak onu run ederken diger
        butun methodlar da Throws olacak. bunun olmasi yorucu gerek yok yani bu nedenle
        try catch secenegini isaretledik
         */
    }

    public static String getProperty(String key){



        return properties.getProperty(key);

        /*
        key'e amazonUrl String'i geliyor
        bunun karsiliginda key->amazonUrl'i alip configuration.properties'e gider(target icindekine)
        burada www.amazon.com ile geri doner. Key ile geldi value ile donmus oldu. Return de www.amazon.com'u
        getirmis oldu. Ancak bu sekilde bir donguyu saglamak icin FileInputStream ile yapabiliriz yani bir dosya yolu
        olusturarak bunu halledebiliriz. Bunun icin bir static bir blok olusturmus olacagiz.

        Bunu static blok yapmamizin nedeni her seyden once calisiyor olmasi. yani her seyden once calisacak ve
        objeye atamayi saglamis olacak.

        Public static yapmamizin nedeni her yerden ulasimi saglayabilmek
         */
    }
}
