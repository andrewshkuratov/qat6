package com.epam.sum_university.uitests.scripts;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ScriptsPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class DBScriptUploadPositive extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void dBScriptUploadPositiv() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/sq1.sql");
        String s = "/scripts/negUploadMax"; boolean check;
        ScriptsPage userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickCreateDB()
                .clickScript()
                .upload("script", file.getAbsolutePath());
        userInformation.capture(s);
        check = userInformation.check();
        Assert.assertFalse(check);

    }
}

