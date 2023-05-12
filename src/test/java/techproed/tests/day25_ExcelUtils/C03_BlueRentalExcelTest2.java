package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.FileNotFoundException;

public class C03_BlueRentalExcelTest2 {
    @Test
    public void test01() throws FileNotFoundException {
     /*
     EXCEL dosyamizdaki tum email ve passwordler ile
     BlueRentalCar sayfasina gidip login olalim?
      */

        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");

        //sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();

        //bir loop olusturup excel dosyasindaki tum verileri girelim.
        for (int i = 1; i < excelUtils.rowCount(); i++) {//i'yi 1 den baslattik cunku veriler 1.satirdan basliyor.
            String email = excelUtils.getCellData(i, 0);
            String password = excelUtils.getCellData(i, 1);
            System.out.println(email + "---" + password);
            blueRentalPage.login.click();
            ReusableMethods.bekle(3);
            blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
            assert blueRentalPage.verify.isDisplayed();
            ReusableMethods.bekle(3);
            blueRentalPage.login3.click();
            ReusableMethods.bekle(3);
            blueRentalPage.logout.click();
            ReusableMethods.bekle(3);
            blueRentalPage.ok.click();
        }
        Driver.closeDriver();
        }

}






