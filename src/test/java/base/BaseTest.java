package base;

import org.testng.annotations.AfterMethod;
import utils.DriverFactory;

public class BaseTest {

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}