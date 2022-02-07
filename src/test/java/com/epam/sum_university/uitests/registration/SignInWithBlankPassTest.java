package com.epam.sum_university.uitests.registration;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_EMAIL;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

// ТС 5. Негативна перевірка для поля password. Поле пусте
public class SignInWithBlankPassTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String s = "registration/blankPass"; boolean check;
        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(ELEPHANT_EMAIL, "", "");
        //errorSignIn.cleanDir(s);
        errorSignIn.capture(s);
        check =  errorSignIn.fillError(); //перевірка на повідомлення
        Assert.assertTrue(check);
    }
}

