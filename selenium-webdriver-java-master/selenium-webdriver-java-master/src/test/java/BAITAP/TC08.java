//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BAITAP;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC08 {
    public TC08() {
    }

    @Test
    public void testTC08() {
        String email = "bao34@gmail.com";
        String password = "bao123";
        String country = "United States";
        String region = "Alabama";
        String zip = "100000";
        String address = "Alabama";
        String city = "Alabama";
        String telephone = "1234566";
        int scc = 0;
        WebDriver driver = driverFactory.getChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        try {
            driver.get("http://live.techpanda.org/");
            loginPage.clickMyAccountLink();
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            Thread.sleep(2000L);
            loginPage.clickLoginButton();
            Thread.sleep(2000L);
            driver.findElement(By.xpath("(//a[@class='link-reorder'][normalize-space()='Reorder'])[3]")).click();
            Thread.sleep(2000L);
            CartPage cartPage = new CartPage(driver);
            cartPage.enterCountry(country);
            cartPage.enterRegion(region, country);
            cartPage.enterZip(zip);
            Thread.sleep(2000L);
            cartPage.clickEstimateButton();
            Thread.sleep(2000L);
            cartPage.clickFlatRateButton();
            cartPage.clickUpdateTotalButton();
            String grandTotal = driver.findElement(By.xpath("(//td[@class='a-right'])[2]")).getText();
            driver.findElement(By.xpath("(//input[@title='Qty'])[1]")).clear();
            driver.findElement(By.xpath("(//input[@title='Qty'])[1]")).sendKeys(new CharSequence[]{"10"});
            Thread.sleep(2000L);
            driver.findElement(By.xpath("(//button[@title='Update'])[1]")).click();
            cartPage.verifyGrandTotal(grandTotal);
            CheckOutPage checkOutPage = new CheckOutPage(driver);
            checkOutPage.clickCheckOutButton();

            Select sAddr;
            int sAddrSize;
            try {
                sAddr = new Select(driver.findElement(By.name("billing_address_id")));
                sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 1);
            } catch (Exception var20) {
                System.out.println("No dropdown element present");
            }

            checkOutPage.enterAddress(address);
            checkOutPage.enterCity(city);
            checkOutPage.enterCountry(country);
            checkOutPage.enterRegion(region, country);
            checkOutPage.enterZip(zip);
            checkOutPage.enterTelephone(telephone);
            Thread.sleep(2000L);
            checkOutPage.clickDifferentAddressButton();
            checkOutPage.clickContinueBillInfoButton();
            Thread.sleep(4000L);

            try {
                sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
                sAddrSize = sAddr.getOptions().size();
                sAddr.selectByIndex(sAddrSize - 1);
            } catch (Exception var19) {
                System.out.println("No dropdown element present");
            }

            Thread.sleep(2000L);
            checkOutPage.clickContinueShipInfoButton();
            Thread.sleep(4000L);
            checkOutPage.clickContinueShipButton();
            Thread.sleep(6000L);
            checkOutPage.clickMoneyOrderButton();
            checkOutPage.clickContinuePaymentButton();
            Thread.sleep(4000L);
            checkOutPage.clickPlaceOrderButton();
            Thread.sleep(4000L);
            String orderVerifyStr = driver.findElement(By.xpath("//div[@class='main-container col1-layout']//p[1]")).getText();
            System.out.println(orderVerifyStr);
            ++scc;
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File srcFile = (File)screenshot.getScreenshotAs(OutputType.FILE);
            String png = "D:\\selenium-webdriver-java-master\\src\\test\\resources\\png/TC08_" + scc + ".png";
            FileHandler.copy(srcFile, new File(png));
        } catch (Exception var21) {
            var21.printStackTrace();
        }

        driver.quit();
    }
}
