package tests;

import base.BaseTest;
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

    @Test(dataProvider = "dashboardsData", description = "Создание и удаление дашборда")
    public void dashboardCreateAndDeleteTest(String name) {
        DashboardPage dashboard = new DashboardPage();
        dashboard.clickCreateDashboard();
        dashboard.typeDashboardName(name);
        dashboard.saveDashboard();

        dashboard.deleteDashboard(name);
    }
}