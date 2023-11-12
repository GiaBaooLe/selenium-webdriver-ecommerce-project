//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BAITAP;

import POM.CartPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC09 {
    public TC09() {
    }

    @Test
    public void testTC09() {
        String country = "United States";
        String region = "Alabama";
        String zip = "100000";
        String coupon = "GURU50";
        WebDriver driver = driverFactory.getChromeDriver();
        CartPage cartPage = new CartPage(driver);

        try {
            driver.get("http://live.techpanda.org/");
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000L);
            driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]")).click();
            String grandTotal = driver.findElement(By.xpath("(//td[@class='a-right'])[2]")).getText();
            cartPage.enterCoupon(coupon);
            cartPage.clickApplyCouponButton();
            Thread.sleep(2000L);
            String couponMsg = driver.findElement(By.xpath("(//li)[13]")).getText();
            System.out.println(couponMsg);
            cartPage.verifyGrandTotal(grandTotal);
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        driver.quit();
    }
}
