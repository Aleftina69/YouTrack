package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(String testName) {
        try {
            File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filename = "screenshots/" + testName + "_" + timestamp + ".png";

            FileHandler.createDir(new File("screenshots"));
            FileHandler.copy(srcFile, new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}