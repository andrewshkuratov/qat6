package com.epam.sum_university.uitests.db;

//29	Перевірка блоку Database user -зміна паролю
import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class ChangeDBPasswordTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void changeDBPassword() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String s = "db/changeDBPassword"; boolean check;
        HomePage positiveChangePass = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS);
        positiveChangePass.capture(s);
        ProfilePage pp = positiveChangePass.clickProfileButton().changeDBPassword(NEW_PASS);
        pp.capture(s);
        check = pp.changePassAlertIsDisplayed();
        Assert.assertTrue(check);
    }
}
