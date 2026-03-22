package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.DashboardPage;

public class SearchDashboardTest extends BaseTest {

    @DataProvider(name = "dashboardsToSearch")
    public Object[][] dashboardsToSearch() {
        return new Object[][]{
                {"Dashboard 1"},
                {"Dashboard 2"},
                {"Dashboard 3"}
        };
    }

    @Test(dataProvider = "dashboardsToSearch", description = "Проверка поиска дашборда")
    public void searchDashboardTest(String dashboardName) {
        DashboardPage dashboard = new DashboardPage();

        dashboard.clickCreateDashboard();
        dashboard.typeDashboardName(dashboardName);
        dashboard.saveDashboard();

        Assert.assertTrue(dashboard.isDashboardCreated(dashboardName),
                "Дашборд '" + dashboardName + "' не найден после создания");

        dashboard.deleteDashboard(dashboardName);
    }
}