package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class DashboardTest extends BaseTest {

    @Test
    public void dashboardCreateAndDeleteTest() {
        DashboardPage dashboard = new DashboardPage();
        dashboard.createDashboard("номер1");
        dashboard.deleteDashboard("номер1");
    }
}