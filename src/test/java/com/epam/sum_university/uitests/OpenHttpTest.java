package com.epam.sum_university.uitests;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;

public class OpenHttpTest extends BaseTest{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String s = "/http";
        HomePage userInformation = loginPage
                .openHttp()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS);
        userInformation.capture(s);
        String check = userInformation.getUserInformationLabel();
        Assert.assertEquals(ELEPHANT_LOGIN, check, "User nicks are not equals");
    }
}
