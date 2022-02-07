package com.epam.sum_university.uitests.login;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;
//9 Негативна перевірка авторизації (введення неіснуючого email та/або password)
public class LoginWithNonExistingEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeLoginTest() throws IOException {
        String s = "/login/notExistMail"; boolean check;
        LoginPage loginPage = new LoginPage(webDriver);
        LoginPage errorSignIn = loginPage
                .open()
                .negLogin(ELEPHANT_LOGIN1, ELEPHANT_PASS);
        //errorSignIn.cleanDir(s);
        errorSignIn.capture(s);
        check =  errorSignIn.existErrorLogin(); //перевірка повідомлення про неіснуючу почту
        Assert.assertTrue(check);
    }
}
