package com.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.demo.Utils.ScreenshotUtil;

import java.time.Duration;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://www.intervue.io/");
            System.out.println("Page Title: " + driver.getTitle());

            clickElement(wait, By.xpath("//a[contains(@class, 'loginBtn')]"));

            driver.get("https://www.intervue.io/access-account");
            System.out.println("Navigated to: " + driver.getCurrentUrl());

            WebElement greenLoginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@class, 'AccessAccount-ColoredButton')]/div[text()='Login']")));
            clickElementWithJS(driver, greenLoginButton);

            handleNewTab(driver);

            // Call the generic login function
            Login.performLogin(driver, wait, "your-email@example.com", "your-secure-password");

            Thread.sleep(5000);

            ScreenshotUtil.takeFullPageScreenshot(driver, "screenshot.png");
            Thread.sleep(1000);
            // Enter valid credentials and log in
            Login.performLogin(driver, wait, "nachikchita@gmail.com", "asdfghrty");

            // Keep the browser open indefinitely
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void clickElement(WebDriverWait wait, By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        System.out.println("Clicked element: " + locator.toString());
    }

    private static void clickElementWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to element
        try {
            Thread.sleep(1000); // Give some time for scrolling
            js.executeScript("arguments[0].click();", element); // Click using JS
            System.out.println("Clicked element using JavaScript.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static void handleNewTab(WebDriver driver) {
        List<String> tabs = List.copyOf(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1)).close();
            System.out.println("Closed the new tab.");
            driver.switchTo().window(tabs.get(0));
        }
    }

}
