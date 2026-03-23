package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class ArticlePage extends BasePage {

    private By createButton = By.xpath("//button[contains(text(),'Создать статью')]");
    private By titleInput = By.xpath("//input[@name='title']");
    private By saveButton = By.xpath("//button[contains(text(),'Сохранить')]");
    private By articleTitle = By.xpath("//h1");

    public void createArticle(String title) {
        click(createButton);
        type(titleInput, title);
        click(saveButton);
    }

    public String getArticleTitle() {
        return getText(articleTitle);
    }
}