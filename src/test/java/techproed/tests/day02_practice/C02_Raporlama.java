package techproed.tests.day02_practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.TestBaseRaporu;

public class C02_Raporlama extends TestBaseRaporu {

    // 'https://www.amazon.com' adresine gidin
    // arama kutusuna "Java" yazip aratın
    // sonuc yazisinin "Java" icerdigini test edin
    // kontrollu olarak yeni bir sayfa acın
    // yeni acılan sayfada "Kitap" aratın
    // sonuc yazisinin Kitap icerdigini test edin

    // test raporu alınız


    @Test
    public void test01() {

        extentTest = extentReports.createTest("tesname", "tanim");


        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.pass("AMAZON SAYFASINA GİDİLDİ");


        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
        extentTest.pass("ARAMA KUTUSUNA JAVA YAZIP ARATILDI");


        // sonuc yazisinin "Java" icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi1.getText().contains("Java"));
        extentTest.pass("SONUC YAZISININ JAVA İCERDİGİ TEST EDİLDİ");


        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.pass("KONTROLLU YENİ SAYFA ACILDI");


        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.aramaKutusu.sendKeys("Kitap" + Keys.ENTER);
        extentTest.pass("YENİ ACILAN SAYFADA KİTAP ARATILDI");


        // sonuc yazisinin Kitap icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi2.getText().contains("Kitap"));
        extentTest.pass("SONUC YAZISININ KİTAP İCERDİGİ TEST EDİLDİ");


        // test raporu alınız

    }
}