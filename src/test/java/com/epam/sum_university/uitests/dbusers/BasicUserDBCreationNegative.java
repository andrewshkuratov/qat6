package com.epam.sum_university.uitests.dbusers;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.DBPage;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

public class BasicUserDBCreationNegative extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBCreation() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean check;
        String s = "/db/createDBBasicNegative";
        HomePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickCreateDB().clickProfileButton().backToHomePage()
                .clickCreateDB().clickProfileButton().backToHomePage();
        fineUpgrade.capture(s);
        check = fineUpgrade.createDBIsClickable();
        Assert.assertTrue(check);
    }
}
