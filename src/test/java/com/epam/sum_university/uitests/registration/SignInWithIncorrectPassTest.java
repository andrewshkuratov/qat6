package com.epam.sum_university.uitests.registration;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

//ТС 6. Негативна перевірка для поля password. Введено некорректний пароль
public class SignInWithIncorrectPassTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String s = "/registration/incorrectPass"; boolean check;
        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(ELEPHANT_EMAIL1, ELEPHANT_INV_PASS, ELEPHANT_INV_PASS);
       // errorSignIn.cleanDir(s);
        errorSignIn.capture(s);
        check =  errorSignIn.fillError(); //перевірка повідомлення про некоректний пароль
        Assert.assertTrue(check);
    }
}
