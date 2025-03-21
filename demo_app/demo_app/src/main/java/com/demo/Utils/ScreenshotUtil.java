package com.demo.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void takeFullPageScreenshot(WebDriver driver, String filePath) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            Thread.sleep(1000);
            
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/" + filePath);
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to save screenshot.");
            e.printStackTrace();
        }
    }
}
