package com.epam.sum_university.uitests.dbusers;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

public class BasicUserProfile extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBProfileAvailable() throws IOException {
        boolean check;
        String s = "/roles/roleChange";
        LoginPage loginPage = new LoginPage(webDriver);

        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton();
        fineUpgrade.capture(s);
        check = fineUpgrade.changeLanguageIsDisplayed();

        Assert.assertTrue(check);
    }
}
