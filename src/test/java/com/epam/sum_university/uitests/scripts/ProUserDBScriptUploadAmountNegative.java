package com.epam.sum_university.uitests.scripts;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.DBPage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.ScriptsPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

public class ProUserDBScriptUploadAmountNegative extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void proUserdBScriptUploadPositiv() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/sq1.sql");
        String s = "/scripts/negUploadPro"; boolean check;
        ScriptsPage userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickProfileButton()
                .upgradeRole()
                .backToHomePage()
                .clickCreateDB()
                .clickScript()
                .upload("script_1", file.getAbsolutePath())
                .upload("script_2", file.getAbsolutePath())
                .upload("script_3", file.getAbsolutePath())
                .upload("script_4", file.getAbsolutePath())
                .upload("script_5", file.getAbsolutePath());
        userInformation.capture(s);
        check = userInformation.scriptAmountErrorIsDisplayed();
        Assert.assertTrue(check);
    }
}


