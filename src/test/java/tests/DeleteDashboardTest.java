package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class DeleteDashboardTest extends BaseTest {

    @DataProvider(name = "dashboardsToDelete")
    public Object[][] dashboardsToDelete() {
        return new Object[][]{
                {"Dashboard 1"},
                {"Dashboard 2"},
                {"Dashboard 3"}
        };
    }

    @Test(dataProvider = "dashboardsToDelete", description = "Удаление дашборда")
    public void deleteDashboardTest(String dashboardName) {
        DashboardPage dashboard = new DashboardPage();

        // Создаём дашборд перед удалением, чтобы точно был что удалять
        dashboard.clickCreateDashboard();
        dashboard.typeDashboardName(dashboardName);
        dashboard.saveDashboard();

        Assert.assertTrue(
                dashboard.isDashboardCreated(dashboardName),
                "Дашборд '" + dashboardName + "' не создан перед удалением"
        );

        // Удаляем дашборд
        dashboard.deleteDashboard(dashboardName);

        // Проверка, что дашборд удалён
        Assert.assertFalse(
                dashboard.isDashboardCreated(dashboardName),
                "Дашборд '" + dashboardName + "' не был удалён"
        );
    }
}