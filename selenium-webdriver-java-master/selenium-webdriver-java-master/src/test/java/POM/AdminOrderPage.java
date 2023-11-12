//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminOrderPage {
    WebDriver driver;
    By orderIdInputLocator = By.id("sales_order_grid_filter_real_order_id");
    By fromDateInputLocator = By.name("created_at[from]");
    By toDateInputLocator = By.name("created_at[to]");
    By searchButton = By.xpath("(//span[contains(text(),'Search')])[1]");
    By closePopupButton = By.xpath("(//a[@title='close'])[1]");
    By salesLink = By.xpath("(//span[normalize-space()='Sales'])[1]");
    By ordersLink = By.xpath("(//span[normalize-space()='Orders'])[1]");

    public AdminOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterOrderId(String orderId) {
        WebElement orderIdElement = this.driver.findElement(this.orderIdInputLocator);
        orderIdElement.clear();
        orderIdElement.sendKeys(new CharSequence[]{orderId});
    }

    public void enterFromDate(String fromDate) {
        WebElement fromDateElement = this.driver.findElement(this.fromDateInputLocator);
        fromDateElement.clear();
        fromDateElement.sendKeys(new CharSequence[]{fromDate});
    }

    public void enterToDate(String toDate) {
        WebElement toDateElement = this.driver.findElement(this.toDateInputLocator);
        toDateElement.clear();
        toDateElement.sendKeys(new CharSequence[]{toDate});
    }

    public void clickSearchButton() {
        this.driver.findElement(this.searchButton).click();
    }

    public void clickCloseButton() {
        this.driver.findElement(this.closePopupButton).click();
    }

    public void clickSalesLink() {
        this.driver.findElement(this.salesLink).click();
    }

    public void clickOrdersLink() {
        this.driver.findElement(this.ordersLink).click();
    }
}
