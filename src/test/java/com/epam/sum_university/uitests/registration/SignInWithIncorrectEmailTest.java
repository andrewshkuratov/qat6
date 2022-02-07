package com.epam.sum_university.uitests.registration;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

// ТС 4. Негативна перевірка для поля e-mail. e-mail введено некоректно
public class SignInWithIncorrectEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String s = "/registration/incorrectMail"; boolean check;
        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(INV_EMAIL, ELEPHANT_PASS, ELEPHANT_PASS);
       // errorSignIn.cleanDir(s);
        errorSignIn.capture(s);
        check =  errorSignIn.fillError(); //перевірка повідомлення про некоректну пошту
        Assert.assertTrue(check);
    }
}


