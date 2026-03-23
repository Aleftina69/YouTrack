package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private By createButton = By.xpath("//button//span[normalize-space()='Create']");
    private By dashboardNameInput = By.xpath("//input[@data-test='dashboard-name-input']");
    private By saveButton = By.xpath("//button//span[normalize-space()='Save']");

    private String dashboardXpath = "//div[.//span[normalize-space()='%s']]";

    private By deleteButton = By.xpath("//button[.//span[normalize-space()='Delete']]");
    private By confirmDeleteButton = By.xpath("//button[.//span[normalize-space()='Delete dashboard']]");

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
        By locator = By.xpath(String.format(dashboardXpath, name));
        return driver.findElements(locator)
                .stream()
                .anyMatch(WebElement::isDisplayed);
    }

    public void deleteDashboard(String name) {
        By dashboardMenu = By.xpath(String.format(dashboardXpath, name) + "//svg");
        click(dashboardMenu);
        click(deleteButton);
        click(confirmDeleteButton);
    }
}