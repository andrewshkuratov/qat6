package com.epam.sum_university.uitests.dbusers;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class NotCheckedUserProfile extends BaseTest{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveNotCheckedUserDBProfileAvailable() throws IOException {
        SignInPage sp = new SignInPage(webDriver);
        String s = "/roles/notChProfile";
        boolean check;
        ProfilePage fineUpgrade = sp
                .open()
                .signIn(ELEPHANT_LOGIN2,ELEPHANT_PASS,ELEPHANT_PASS)
                .clickProfileButton();
        fineUpgrade.capture(s);
        check = fineUpgrade.changeLanguageIsDisplayed();
        Assert.assertTrue(check);
    }
}
