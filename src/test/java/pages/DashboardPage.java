package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.WaitUtil;

public class DashboardPage {

    private WebDriver driver;

    private By createButton = By.cssSelector("[data-test='ring-link']");
    private By dashboardCard(String name) { return By.xpath("//div[.//span[text()='" + name + "']]"); }
    private By deleteButton = By.cssSelector("[data-test='delete']"); // пример, заменить на актуальный

    public DashboardPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void createDashboard(String name) {
        WaitUtil.waitForClickable(driver, createButton, 10).click();
        // добавить логику ввода имени и сохранения
    }

    public void deleteDashboard(String name) {
        WaitUtil.waitForClickable(driver, dashboardCard(name), 10).click();
        WaitUtil.waitForClickable(driver, deleteButton, 10).click();
    }
}