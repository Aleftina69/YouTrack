package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ArticlePage;

public class ArticleTest extends BaseTest {

    @DataProvider(name = "articlesData")
    public Object[][] articlesData() {
        return new Object[][]{
                {"Статья номер 1"},
                {"Статья номер 2"},
                {"Статья номер 3"}
        };
    }

    @Test(dataProvider = "articlesData", description = "Создание статьи")
    public void articleCreateTest(String title) {
        ArticlePage articlePage = new ArticlePage();
        articlePage.createArticle(title);
    }
}