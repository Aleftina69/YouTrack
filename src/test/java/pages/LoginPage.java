package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.WaitUtil;

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By usernameField = By.cssSelector("[data-test='username-field']");
    private By passwordField = By.cssSelector("[data-test='password-field']");
    private By loginButton = By.cssSelector("[data-test='login-button']");

    public void login(String username, String password) {
        WaitUtil.waitForClickable(driver, loginButton, 10).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}