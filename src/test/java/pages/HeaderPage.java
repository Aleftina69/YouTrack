package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.WaitUtil;

public class HeaderPage {

    private WebDriver driver;

    private By userMenu = By.cssSelector("[data-test='ring-dropdown ring-profile']");
    private By logoutButton = By.xpath("//button[contains(text(),'Log out')]");

    public HeaderPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void logout() {
        WaitUtil.waitForClickable(driver, userMenu, 10).click();
        WaitUtil.waitForClickable(driver, logoutButton, 10).click();
    }
}