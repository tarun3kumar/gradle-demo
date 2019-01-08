package com.org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BasePage {

    private WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
    }

    public boolean isElementDisplayed(By locator) {
        Stream<WebElement> webElementStream = findElements(locator).stream();
        Optional<WebElement> optionalWebElement = webElementStream.findFirst();
        return optionalWebElement.map(WebElement::isDisplayed).orElse(false);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

}
