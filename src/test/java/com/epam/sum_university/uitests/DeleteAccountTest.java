package com.epam.sum_university.uitests;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class DeleteAccountTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void deleteUserAccount() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String s = "/acc/delete"; boolean check;
        ProfilePage deleteUserAccount = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton();
        deleteUserAccount.capture(s);
        deleteUserAccount.deleteUserAcc();
        deleteUserAccount.capture(s);
        check = deleteUserAccount.deleteAccAlertIsDisplayed();
        Assert.assertTrue(check);
    }
}
