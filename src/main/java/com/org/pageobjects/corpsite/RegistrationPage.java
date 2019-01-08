package com.org.pageobjects.corpsite;

import com.org.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private static final By firstNameTextBox = By.id("firstName");

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
        if(! isFirstNameDisplayed()) {
            throw new IllegalStateException("This is not registration page!");
        }
    }

    public boolean isFirstNameDisplayed() {
        return isElementDisplayed(firstNameTextBox);
    }
}
