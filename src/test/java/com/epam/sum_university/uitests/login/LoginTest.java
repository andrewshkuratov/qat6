package com.epam.sum_university.uitests.login;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.HomePage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.epam.sum_university.properties.Properties.ELEPHANT_LOGIN;
import static com.epam.sum_university.properties.Properties.ELEPHANT_PASS;
// TC 8. Позитивна перевірка авторизації
public class LoginTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() throws IOException{
        String s = "login/posLogin";
        LoginPage loginPage = new LoginPage(webDriver);
        HomePage userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS);
        userInformation.cleanDir(s);
        userInformation.capture(s);
        String label = userInformation.getUserInformationLabel();
        Assert.assertEquals("alyashelya@gmail.com",label, "User nicks are not equals");
    }
    @Test
    public void positiveUnmask() throws IOException {
        String oldValue, newValue, s = "unmask";
        LoginPage loginPage = new LoginPage(webDriver);
        LoginPage lp = loginPage
                .open().enterPass(ELEPHANT_PASS);
        //lp.cleanDir(s);
        oldValue = lp.getTypeValue();
        lp.capture(s);
        lp.clickUnmask();
        newValue = lp.getTypeValue();
        lp.capture(s);
        Assert.assertTrue(oldValue.equals("password")&newValue.equals("text"));
    }

}
