package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class DashboardTest extends BaseTest {

    @DataProvider(name = "dashboardsData")
    public Object[][] dashboardsData() {
        return new Object[][]{
                {"Dashboard 1"},
                {"Dashboard 2"},
                {"Dashboard 3"}
        };
    }

    @Test(dataProvider = "dashboardsData", description = "Создание дашборда")
    public void dashboardCreateTest(String name) {
        DashboardPage dashboard = new DashboardPage();

        dashboard.clickCreateDashboard();
        dashboard.typeDashboardName(name);
        dashboard.saveDashboard();

        Assert.assertTrue(
                dashboard.isDashboardCreated(name),
                "Дашборд не был создан"
        );
    }
}