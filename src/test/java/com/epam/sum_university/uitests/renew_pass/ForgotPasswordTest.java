package com.epam.sum_university.uitests.renew_pass;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ResetPasswordPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;

public class ForgotPasswordTest extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positivePassRenew() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String s = "/password/forgot"; boolean check;
        ResetPasswordPage value = loginPage
                .open()
                .forgotPassword();
        value.capture(s);
        ResetPasswordPage q = value.reset(ELEPHANT_LOGIN);
        value.capture(s);
                check = q.findMessage();
        Assert.assertTrue(check);
    }

}
