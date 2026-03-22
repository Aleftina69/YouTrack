package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ArticlePage;

public class ArticleTest extends BaseTest {

    @Test
    public void articleCreateTest() {
        ArticlePage articlePage = new ArticlePage();
        articlePage.createArticle("номер1");
    }
}