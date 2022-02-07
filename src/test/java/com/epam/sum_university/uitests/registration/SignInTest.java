package com.epam.sum_university.uitests.registration;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;
// ТС 1 . Позитивна реєстрація користувача
public class SignInTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveSignInTest() throws IOException {
        String s = "posRegistration", label; boolean message;
        HomePage userInformation;
        SignInPage signInPage;
        signInPage = new SignInPage(webDriver);
        signInPage.open();//.cleanDir(s);
        signInPage.capture(s);
        userInformation = signInPage.signIn(ELEPHANT_EMAIL2, ELEPHANT_PASS, ELEPHANT_PASS);
        userInformation.capture(s);
        label = userInformation.getUserInformationLabel(); //перевірка редіректа на домашню сторінку
        message = userInformation.messageIsDisplayed();//перевірка появи повідомлення про надсилання смс на пошту
        Assert.assertEquals(ELEPHANT_EMAIL2, label, "User nicks are not equals");
        Assert.assertTrue(message);
    }
}
