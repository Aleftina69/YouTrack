package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeLogout() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Test(description = "Проверка успешного выхода")
    public void logoutTest() {
        HeaderPage headerPage = new HeaderPage();
        headerPage.logout();

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Пользователь не вышел с системы");
    }
}