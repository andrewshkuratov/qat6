package com.epam.sum_university.uitests;


import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

// Test Case 31 - Changing Web Password (User Profile)
public class ChangePasswordTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void changeWebPassword() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String s = "/web/changePass"; boolean check;
        ProfilePage positiveChangePass = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton();
        positiveChangePass.capture(s);
        positiveChangePass.changeWebPassword(NEW_PASS, NEW_PASS);
        positiveChangePass.capture(s);
        check=positiveChangePass.changePassAlertIsDisplayed();
        Assert.assertTrue(check);
    }
}
