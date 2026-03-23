package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private final int TIMEOUT = 10;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    protected WebElement waitForVisibility(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitForClickable(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void click(By by) {
        waitForClickable(by).click();
    }

    protected void type(By by, String text) {
        WebElement element = waitForVisibility(by);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By by) {
        return waitForVisibility(by).getText();
    }

    protected boolean isVisible(By by) {
        return !driver.findElements(by).isEmpty();
    }
}