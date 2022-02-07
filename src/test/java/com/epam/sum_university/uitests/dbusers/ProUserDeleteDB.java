package com.epam.sum_university.uitests.dbusers;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.DBPage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

public class ProUserDeleteDB extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void deleteDbProUser() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean check;
        String s = "/db/deleteDBPro";
        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS).clickProfileButton()
                .upgradeRole();
        fineUpgrade.capture(s);
        DBPage db = fineUpgrade.backToHomePage().clickCreateDB();
        fineUpgrade.capture(s);
        check = db.clickProfileButton().backToHomePage().DeleteDB();
        Assert.assertTrue(check);
    }
}
