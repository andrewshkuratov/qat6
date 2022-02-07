package com.epam.sum_university.uitests.registration;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;
// TC 3. Негативна перевірка для поля e-mail. e-mail поля пусте
public class SignInWithBlankEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String s = "registration/blankMail"; boolean check;
        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn("", ELEPHANT_PASS, ELEPHANT_PASS);
        //errorSignIn.cleanDir(s);
        errorSignIn.capture(s);
        check =  errorSignIn.fillError(); //перевірка на повідомлення
        Assert.assertTrue(check);
    }
}

