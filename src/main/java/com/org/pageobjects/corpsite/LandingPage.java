package com.org.pageobjects.corpsite;

import com.org.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private WebDriver webDriver;

    private static final By registrationLink = By.cssSelector("a[href *= 'registration.html']");
    private static final By signInLink = By.cssSelector("a[href $= 'org.de/']");

    public LandingPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        if(! isElementDisplayed(registrationLink)) {
            throw new IllegalStateException("This is not corp landing page!");
        }
    }

    public RegistrationPage getRegistrationPage() {
        click(registrationLink);
        return new RegistrationPage(webDriver);
    }


}
