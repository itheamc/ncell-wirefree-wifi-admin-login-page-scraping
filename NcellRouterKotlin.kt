package com.itheamc.webscrapping

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.File
import java.sql.DriverManager.println
import java.time.Duration

class NcellRouterKotlin {

    fun main() {

        // Specify the path of the WebDriver (Chrome, Firefox etc.) you are going to use
        // Here i have used ChromeDriver and specify the path C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe
        val chromeDriverService = ChromeDriverService.Builder().usingChromeDriverExecutable(File("C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe")).build()
        val driver: WebDriver = ChromeDriver(chromeDriverService)

        // Creating new instance of WebDriverWait variable to wait for 10 seconds
        val wait = WebDriverWait(driver, Duration.ofSeconds(10).seconds)
        try {
            driver["http://192.168.0.1"]

            // targeting the login button
            val loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginlink")))
            loginBtn.click()
            Thread.sleep(1000)
            // Targeting the input fields to send keys as username and password
            val username = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='txtUsr']")))
            val password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='txtPwd']")))

            // enter username and password
            username.clear()
            username.sendKeys("admin")      // Enter your username here
            Thread.sleep(2000)
            password.clear()
            password.sendKeys("admin")      // Enter your password here
            Thread.sleep(1000)
            // Targeting the button element to login
            val button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnLogin")))
            button.click()
            Thread.sleep(4000)
            // targeting to setting div to see the data usage
            val div = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-trans='device_setting']")))
            div.click()

            // Targeting to the data usage setting to see data usage

            // Targeting to the data usage setting to see data usage
            Thread.sleep(1000)
            val dataUsageSetting = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-trans='statistics_settings']")))
            dataUsageSetting.click()
        } catch (e: Exception) {
            println(e.message)
        }
    }
}