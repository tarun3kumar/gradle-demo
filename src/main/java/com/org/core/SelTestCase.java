package com.org.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.org.core.BrowserType.*;

public class SelTestCase {

    public WebDriver getDriver() {
        return webDriver;
    }

    private WebDriver webDriver;

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setUp(@Optional("firefox") String browser, @Optional("https://www.google.com/") String URL) {
        switch (browser) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getClass().getResource("/geckodriver").getPath());
                webDriver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getClass().getResource("/chromedriver").getPath());
                webDriver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException("Invalid Browser");
        }
        webDriver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
