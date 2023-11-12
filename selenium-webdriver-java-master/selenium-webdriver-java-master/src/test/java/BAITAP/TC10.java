//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BAITAP;

import POM.AdminLoginPage;
import POM.AdminOrderPage;
import driver.driverFactory;
import java.io.File;
import java.util.Iterator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TC10 {
    public TC10() {
    }

    @Test
    public void testTC10() {
        String username = "user01";
        String password = "guru99com";
        String orderId = "100021255";
        String fromDate = "11/8/2023";
        String toDate = "11/10/2023";
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            AdminLoginPage arg = new AdminLoginPage(driver);
            arg.enterUsername(username);
            arg.enterPassword(password);
            arg.clickLoginButton();
            Thread.sleep(4000L);
            AdminOrderPage op = new AdminOrderPage(driver);
            Iterator var9 = driver.getWindowHandles().iterator();

            while(var9.hasNext()) {
                String handle = (String)var9.next();
                driver.switchTo().window(handle);
            }

            op.clickCloseButton();
            Thread.sleep(2000L);
            op.clickSalesLink();
            op.clickOrdersLink();
            op.enterOrderId(orderId);
            Thread.sleep(2000L);
            op.enterFromDate(fromDate);
            op.enterToDate(toDate);
            op.clickSearchButton();
            Thread.sleep(2000L);
            int scc = 0;
            ++scc;
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File srcFile = (File)screenshot.getScreenshotAs(OutputType.FILE);
            String png = "D:\\selenium-webdriver-java-master\\src\\test\\resources\\png/TC10_" + scc + ".png";
            FileHandler.copy(srcFile, new File(png));
        } catch (Exception var13) {
            var13.printStackTrace();
        }

        driver.quit();
    }
}
