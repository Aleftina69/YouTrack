package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By usernameInput = By.xpath("//input[@id='login']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@id='login-submit']");

    private By loginForm = By.xpath("//form[@id='login-form']");

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }

    public boolean isLoginPageDisplayed() {
        return isVisible(loginForm);
    }
}