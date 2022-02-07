package com.epam.sum_university.uitests.db;


import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.TablePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

// Test Case 33 Перевірка Database explorer, відображення таблиць
public class CheckDisplayTableDataTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void checkDisplayTableData() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        File file = new File("src/test/resources/scripts/sq1.sql");
        String s = "/checkDBExpl/checkDisplayTable";
        boolean error;

        TablePage checkDisplayTableData = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickCreateDB()
                .clickScript()
                .upload("йцу", file.getAbsolutePath())
                .runScript()
                .clickDataExplorerButton()
                .сlickdbTableName();
        checkDisplayTableData.capture(s);
        error = checkDisplayTableData.positiveCheckDisplayTablenInfo();

        Assert.assertTrue(error);
    }
}
