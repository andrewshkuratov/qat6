package com.epam.sum_university.uitests.db;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.BackUpPage;
import com.epam.sum_university.pageobject.pages.DBPage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import com.epam.sum_university.pageobject.pages.TablePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

// Test Case 40
public class DatabaseUpdateTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void databaseUpdate() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver); boolean check;
        File file = new File("src/test/resources/scripts/sq1.sql");
        String s = "/db/update";
        BackUpPage databaseUpdate = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickCreateDB()
                .clickBackupButton();
        databaseUpdate.capture(s);
        DBPage dp = databaseUpdate.posCreateBackup(BACKUP_NAME1).databaseUpdate();
        dp.capture(s);
        check = dp.checkTable();

        Assert.assertTrue(check);
    }
}
