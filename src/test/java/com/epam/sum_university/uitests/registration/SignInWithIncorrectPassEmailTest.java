package com.epam.sum_university.uitests.registration;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class SignInWithIncorrectPassEmailTest extends BaseTest {
//TC 7. Негативна перевірка. Некорректний email та password
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String s = "/registration/incorrectPassMail"; boolean check;
        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(INV_EMAIL, ELEPHANT_INV_PASS, ELEPHANT_INV_PASS);
        //errorSignIn.cleanDir(s);
        errorSignIn.capture(s);
        check =  errorSignIn.fillError(); //перевірка повідомлення про некоректні дані
        Assert.assertTrue(check);
    }
}


