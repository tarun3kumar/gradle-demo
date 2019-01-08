package com.org.corpsite;

import com.org.core.SelTestCase;
import com.org.pageobjects.corpsite.LandingPage;
import com.org.pageobjects.corpsite.RegistrationPage;
import org.testng.annotations.Test;

import static com.org.core.TestGroup.SMOKE_TEST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LandingPageTest extends SelTestCase {

    @Test(groups = SMOKE_TEST)
    public void accessRegistrationPage() {
        RegistrationPage registrationPage = new LandingPage(getDriver()).getRegistrationPage();
        assertThat("Unable to reach registration page", registrationPage.isFirstNameDisplayed(), is(equalTo(true)));
    }
}
