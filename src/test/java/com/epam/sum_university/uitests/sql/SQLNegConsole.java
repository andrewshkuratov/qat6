package com.epam.sum_university.uitests.sql;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;

import static com.epam.sum_university.properties.Properties.*;

public class SQLNegConsole extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void dbRunScript() {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/script.sql");

        boolean userInformation = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickCreateDB()
                .clickSQL()
                .enterCommmand("\n" +
                        "CREATE TBLE emp\n" +
                        "(\n" +
                        "    Id int,\n" +
                        "    FirstName NVARCHAR(20),\n" +
                        "    LastName NVARCHAR(20) \n" +
                        "    Email VARCHAR(30),\n" +
                        "    Phone VARCHAR(20)\n" +
                        ")")
                .resultSQL();

        Assert.assertTrue(userInformation);
    }
}