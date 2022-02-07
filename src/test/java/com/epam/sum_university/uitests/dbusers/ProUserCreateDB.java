package com.epam.sum_university.uitests.dbusers;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.DBPage;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class ProUserCreateDB extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveProUserDBCreation() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean check;
        String s = "/db/createDBPro";
        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS).clickProfileButton().upgradeRole();
        fineUpgrade.capture(s);
        HomePage hp = fineUpgrade.backToHomeLogo();
        DBPage dp = hp.clickCreateDB();
        hp.capture(s);
        check = dp.checkDB();
        Assert.assertTrue(check);
    }
}
