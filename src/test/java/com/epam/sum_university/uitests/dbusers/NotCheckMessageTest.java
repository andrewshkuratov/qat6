package com.epam.sum_university.uitests.dbusers;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class NotCheckMessageTest extends BaseTest {
        @AfterTest
        public void tearDown() {
            quit();
        }

        @Test
        public void displayNotCheckedUserMessage() throws IOException {
            SignInPage sp = new SignInPage(webDriver);
            String s = "/roles/notChMessage";
            boolean check;
            HomePage value = sp
                    .open()
                    .signIn(ELEPHANT_LOGIN2,ELEPHANT_PASS,ELEPHANT_PASS);
            value.capture(s);
            check = value.messageIsDisplayed();
            Assert.assertTrue(check);
        }
    }

