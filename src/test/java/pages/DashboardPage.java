package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private By createButton = By.xpath("//button//span[contains(text(),'Create')]");
    private By dashboardNameInput = By.xpath("//input[@data-test='dashboard-name-input']");
    private By saveButton = By.xpath("//button//span[contains(text(),'Save')]");
    private String dashboardXpath = "//div[.//span[text()='%s']]";

    public void clickCreateDashboard() {
        click(createButton);
    }

    public void typeDashboardName(String name) {
        type(dashboardNameInput, name);
    }

    public void saveDashboard() {
        click(saveButton);
    }

    public boolean isDashboardCreated(String name) {
        return isVisible(By.xpath(String.format(dashboardXpath, name)));
    }

    public void deleteDashboard(String name) {
        By dashboardMenu = By.xpath(String.format(dashboardXpath, name) + "//svg");
        click(dashboardMenu);
        click(By.xpath("//button//span[contains(text(),'Delete')]"));
        click(By.xpath("//button//span[contains(text(),'Delete dashboard')]"));
    }
}