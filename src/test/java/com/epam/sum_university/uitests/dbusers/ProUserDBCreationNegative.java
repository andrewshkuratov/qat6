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

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

public class ProUserDBCreationNegative extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBCreation() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean check;
        String s = "/db/createDBProNegat";
        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton()
                .upgradeRole();
        fineUpgrade.capture(s);
        HomePage hp = fineUpgrade.backToHomePage();
        DBPage db = hp.clickCreateDB();
        db.capture(s);
        hp = db.clickProfileButton().backToHomePage();
        db = hp.clickCreateDB();
        db.capture(s);
        db.clickProfileButton().backToHomePage();
        db = hp.clickCreateDB();
        db.capture(s);
        hp = db.clickProfileButton().backToHomePage();
        check = hp.createDBIsClickable();
        Assert.assertTrue(check);
    }
}
