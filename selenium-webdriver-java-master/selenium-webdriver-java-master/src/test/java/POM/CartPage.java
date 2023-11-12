//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class CartPage {
    WebDriver driver;
    By cartButton = By.xpath("(//button[@title='Add to Cart'])[1]");
    By countryInputLocator = By.id("country");
    By stateInputLocator = By.id("region_id");
    By provinceInputLocator = By.id("region");
    By zipInputLocator = By.id("postcode");
    By estimateButton = By.xpath("(//span[contains(text(),'Estimate')])[1]");
    By flatRateValue = By.xpath("(//label[contains(text(),'Fixed')])[1]");
    By flatRate = By.xpath("(//dt[normalize-space()='Flat Rate'])[1]");
    By flatRateButton = By.xpath("(//input[@id='s_method_flatrate_flatrate'])[1]");
    By updateTotalButton = By.xpath("(//button[@title='Update Total'])[1]");
    By subtotalLocator = By.xpath("(//td)[13]");
    By shippingCostLocator = By.xpath("(//td[@class='a-right'])[6]");
    By grandTotalLocator = By.xpath("(//td[@class='a-right'])[2]");
    By couponInputLocator = By.xpath("(//input[@id='coupon_code'])[1]");
    By applyCouponButton = By.xpath("(//span[contains(text(),'Apply')])[1]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartButton() {
        this.driver.findElement(this.cartButton).click();
    }

    public void enterCountry(String country) {
        WebElement countryElement = this.driver.findElement(this.countryInputLocator);
        (new Select(countryElement)).selectByVisibleText(country);
    }

    public void enterRegion(String region, String country) {
        WebElement stateElement;
        if (country.equals("United States")) {
            stateElement = this.driver.findElement(this.stateInputLocator);
            (new Select(stateElement)).selectByVisibleText(region);
        } else {
            stateElement = this.driver.findElement(this.provinceInputLocator);
            stateElement.clear();
            stateElement.sendKeys(new CharSequence[]{region});
        }

    }

    public void enterZip(String zip) {
        WebElement zipElement = this.driver.findElement(this.zipInputLocator);
        zipElement.clear();
        zipElement.sendKeys(new CharSequence[]{zip});
    }

    public void clickEstimateButton() {
        this.driver.findElement(this.estimateButton).click();
    }

    public String verifyGenerated() {
        String checkTextStr = this.driver.findElement(this.flatRate).getText();
        String checkValueStr = this.driver.findElement(this.flatRateValue).getText();
        AssertJUnit.assertEquals("Flat Rate", checkTextStr);
        AssertJUnit.assertEquals("Fixed - $5.00", checkValueStr);
        return checkValueStr;
    }

    public void clickFlatRateButton() {
        this.driver.findElement(this.flatRateButton).click();
    }

    public void clickUpdateTotalButton() {
        this.driver.findElement(this.updateTotalButton).click();
    }

    public void verifyTotal() {
        double subTotal = Double.parseDouble(this.driver.findElement(this.subtotalLocator).getText().substring(1));
        double shippingCost = Double.parseDouble(this.driver.findElement(this.shippingCostLocator).getText().substring(1));
        double grandTotal = Double.parseDouble(this.driver.findElement(this.grandTotalLocator).getText().substring(1));
        System.out.println("Sub Total: $" + subTotal);
        System.out.println("Shipping Cost: $" + shippingCost);
        System.out.println("Grand Total: $" + grandTotal);
        AssertJUnit.assertEquals(grandTotal, subTotal + shippingCost);
    }

    public void verifyGrandTotal(String preGrandTotal) {
        String afterGrandTotal = this.driver.findElement(this.grandTotalLocator).getText();
        System.out.println("Grand Total: " + preGrandTotal);
        System.out.println("Grand Total after update: " + afterGrandTotal);
        Assert.assertNotEquals(preGrandTotal, afterGrandTotal);
    }

    public void enterCoupon(String coupon) {
        WebElement couponElement = this.driver.findElement(this.couponInputLocator);
        couponElement.clear();
        couponElement.sendKeys(new CharSequence[]{coupon});
    }

    public void clickApplyCouponButton() {
        this.driver.findElement(this.applyCouponButton).click();
    }
}
