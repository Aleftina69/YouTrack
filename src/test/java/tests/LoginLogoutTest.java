package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverFactory;
import utils.WaitUtil;

public class LoginLogoutTest extends BaseTest {

    private WebDriver driver = DriverFactory.getDriver();

    private By usernameInput = By.id("login");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-submit");

    @Test
    public void loginAndLogoutTest() {
        driver.get("http://localhost:8080"); // URL YouTrack

        // Логин
        WaitUtil.waitForElement(driver, usernameInput, 10).sendKeys("admin");
        WaitUtil.waitForElement(driver, passwordInput, 10).sendKeys("0000");
        WaitUtil.waitForClickable(driver, loginButton, 10).click();

        // Логаут через HeaderPage
        pages.HeaderPage header = new pages.HeaderPage();
        header.logout();
    }
}