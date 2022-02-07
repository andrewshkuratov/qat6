package com.epam.sum_university.uitests;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

public class RegenerateKeyTest extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String [] keysOld, keysNew; String s = "/regenerate";
        ProfilePage profilePage = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton();
        profilePage.capture(s);
        keysOld = profilePage.getKeyValue();
        profilePage.regenerate();
        profilePage.capture(s);
        keysNew = profilePage.getKeyValue();
        Assert.assertNotEquals(keysOld, keysNew);
    }
}
