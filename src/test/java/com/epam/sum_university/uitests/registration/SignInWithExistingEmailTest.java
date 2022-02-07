package com.epam.sum_university.uitests.registration;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;
// ТС 2. Реєстрація з існуючою поштою
public class SignInWithExistingEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String s = "/registration/existMail"; boolean check;
        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(ELEPHANT_LOGIN, ELEPHANT_PASS, ELEPHANT_PASS);
        //errorSignIn.cleanDir(s);
        errorSignIn.capture(s);
        check =  errorSignIn.existErrorSignIn(); //перевірка повідомлення про існуючу почту
        Assert.assertTrue(check);
    }
}

