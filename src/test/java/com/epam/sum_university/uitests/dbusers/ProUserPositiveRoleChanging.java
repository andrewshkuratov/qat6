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

public class ProUserPositiveRoleChanging extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveProUserRoleChanging() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean check;
        String s = "/roles/change";
        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton()
                .upgradeRole();
        fineUpgrade.capture(s);
        check = fineUpgrade.getUpgradeRole();
        Assert.assertTrue(check);
    }
}

