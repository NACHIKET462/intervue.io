package com.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Login<T> {

    private static void enterText(WebDriverWait wait, By by, String text) {
        WebElement element = wait.until(driver -> driver.findElement(by));
        element.clear(); // Clear existing text
        element.sendKeys(text);
    }

    private static void clickElement(WebDriverWait wait, By by) {
        wait.until(driver -> driver.findElement(by)).click();
    }

    /**
     * Generic method to perform login with given credentials.
     */
    static void performLogin(WebDriver driver, WebDriverWait wait, String email, String password) {
        enterText(wait, By.id("login_email"), email);
        enterText(wait, By.id("login_password"), password);

        clickElement(wait, By.xpath("//button[@type='submit' and contains(@class, 'LoginDarkButton-sc-1ertvag-0')]"));
        System.out.println("Login submitted.");
    }
}

