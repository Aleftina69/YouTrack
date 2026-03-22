package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.WaitUtil;

public class ArticlePage {

    private WebDriver driver;

    private By createButton = By.cssSelector("[data-test='ring-link']");
    private By newArticleLink = By.linkText("New article");
    private By titleInput = By.cssSelector("[data-test='summary']");
    private By publishButton = By.cssSelector("[data-test='publish-button']");

    public ArticlePage() {
        this.driver = DriverFactory.getDriver();
    }

    public void createArticle(String title) {
        WaitUtil.waitForClickable(driver, createButton, 10).click();
        WaitUtil.waitForClickable(driver, newArticleLink, 10).click();
        WaitUtil.waitForElement(driver, titleInput, 10).sendKeys(title);
        WaitUtil.waitForClickable(driver, publishButton, 10).click();
    }
}