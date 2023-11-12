//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {
    WebDriver driver;
    By usernameInputLocator = By.id("username");
    By passwordInputLocator = By.id("login");
    By loginButton = By.xpath("(//input[@title='Login'])[1]");

    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameElement = this.driver.findElement(this.usernameInputLocator);
        usernameElement.clear();
        usernameElement.sendKeys(new CharSequence[]{username});
    }

    public void enterPassword(String password) {
        WebElement passwordElement = this.driver.findElement(this.passwordInputLocator);
        passwordElement.clear();
        passwordElement.sendKeys(new CharSequence[]{password});
    }

    public void clickLoginButton() {
        this.driver.findElement(this.loginButton).click();
    }
}
