package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By usernameInput = By.xpath("//input[@id='login']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@id='login-submit']");

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }
}