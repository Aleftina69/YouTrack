package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;
import utils.WaitUtil;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    protected void click(By by) {
        WaitUtil.waitForClickable(driver, by, 10).click();
    }

    protected void type(By by, String text) {
        WebElement element = WaitUtil.waitForElement(driver, by, 10);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By by) {
        return WaitUtil.waitForElement(driver, by, 10).getText();
    }

    protected boolean isVisible(By by) {
        try {
            WaitUtil.waitForElement(driver, by, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}