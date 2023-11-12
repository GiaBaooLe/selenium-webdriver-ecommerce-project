//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BAITAP;

import POM.LoginPage;
import driver.driverFactory;
import java.io.File;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TC07 {
    public TC07() {
    }

    @Test
    public void testTC07() {
        String email = "bao34@gmail.com";
        String password = "bao123";
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
            driver.findElement(By.linkText("MY ORDERS")).click();
            Thread.sleep(2000L);
            driver.findElement(By.xpath("(//a[contains(text(),'View Order')])[1]")).click();
            Thread.sleep(2000L);
            driver.findElement(By.xpath("(//a[normalize-space()='Print Order'])[1]")).click();
            Thread.sleep(2000L);
            Iterator var6 = driver.getWindowHandles().iterator();

            while(var6.hasNext()) {
                String handle = (String)var6.next();
                driver.switchTo().window(handle);
            }

            Thread.sleep(200L);
            ++scc;
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File srcFile = (File)screenshot.getScreenshotAs(OutputType.FILE);
            String png = "D:\\selenium-webdriver-java-master\\src\\test\\resources\\png/TC07_" + scc + ".png";
            FileHandler.copy(srcFile, new File(png));
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        driver.quit();
    }
}
