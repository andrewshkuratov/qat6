package com.epam.sum_university.uitests.login;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.modules.LogoutModule;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;
//10 	Prerequisites: здійснити вхід у систему.
// Перевірка log out
public class LogOutTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void logoutTest() throws IOException {
        String s = "/login/logOut"; boolean check;
        LoginPage loginPage = new LoginPage(webDriver);
        LoginPage lp = loginPage
                .open();
        //lp.cleanDir(s);
        lp.capture(s);
        HomePage hp = lp.login(ELEPHANT_LOGIN, ELEPHANT_PASS);
        hp.capture(s);
        LogoutModule lm = new LogoutModule(webDriver);
        lm = hp.logout();
        lm.capture(s);
        check = lm.getLoginField();
        Assert.assertTrue(check);
    }
}
