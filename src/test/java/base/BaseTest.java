package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.TestListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected Properties properties;
    protected String baseUrl;
    protected String username;
    protected String password;

    @BeforeClass
    public void loadProperties() throws IOException {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"url"})
    public void setUp(@Optional String url) {
        driver = DriverFactory.getDriver();
        baseUrl = (url != null && !url.isEmpty())
                ? url
                : properties.getProperty("url");

        username = properties.getProperty("username");
        password = properties.getProperty("password");

        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}