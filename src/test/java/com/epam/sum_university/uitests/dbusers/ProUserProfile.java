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

public class ProUserProfile extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBProfileAvailable() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean check;
        String s = "/roles/proProfile";
        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton()
                .upgradeRole();
        fineUpgrade.capture(s);
        ProfilePage pp = fineUpgrade.backToHomePage().clickProfileButton();
        pp.capture(s);
        check = pp.changeLanguageIsDisplayed();

        Assert.assertTrue(check);
    }
}
