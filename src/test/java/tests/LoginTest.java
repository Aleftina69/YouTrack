package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка успешного входа")
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        DashboardPage dashboard = new DashboardPage();

        Assert.assertTrue(
                dashboard.isDashboardCreated("Default"),
                "Dashboard не отображается после логина"
        );
    }
}