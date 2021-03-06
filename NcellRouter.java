package com.itheamc.webscrapping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class NcellRouter {

    public static void main(String[] args) {

        // Specify the path of the WebDriver (Chrome, Firefox etc.) you are going to use
        // Here i have used ChromeDriver and specify the path C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe
        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File("C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe")).build();
        WebDriver driver = new ChromeDriver(chromeDriverService);

        // Creating new instance of WebDriverWait variable to wait for 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        try {
            driver.get("http://192.168.0.1");

            // targeting the login button
            WebElement login_btn = wait.until(elementToBeClickable(By.id("loginlink")));
            login_btn.click();

            Thread.sleep(1000);
            // Targeting the input fields to send keys as username and password
            WebElement username = wait.until(presenceOfElementLocated(By.cssSelector("input[name='txtUsr']")));
            WebElement password = wait.until(presenceOfElementLocated(By.cssSelector("input[name='txtPwd']")));

            // enter username and password
            username.clear();
            username.sendKeys("admin");       // Enter your username here
            Thread.sleep(1000);
            password.clear();
            password.sendKeys("admin");      // Enter your password here

            Thread.sleep(1000);
            // Targeting the button element to login
            WebElement button = wait.until(elementToBeClickable((By.id("btnLogin"))));
            button.click();

            Thread.sleep(2000);
            // targeting to setting div to see the connected device
            WebElement div = wait.until(elementToBeClickable(By.cssSelector("a[data-trans='device_setting']")));
            div.click();

            // Targeting to the data usage setting to see data usage
            Thread.sleep(1000);
            WebElement dataUsageSetting = wait.until(elementToBeClickable(By.cssSelector("a[data-trans='statistics_settings']")));
            dataUsageSetting.click();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
