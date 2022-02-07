package com.epam.sum_university.uitests.backups;

import com.epam.sum_university.BaseTest;
import com.epam.sum_university.pageobject.pages.BackUpPage;
import com.epam.sum_university.pageobject.pages.DBPage;
import com.epam.sum_university.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.sum_university.properties.Properties.*;

// Test Case 36 - Remove the backup (Backup Page)
public class RemoveBackupTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void removeDatabase() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        String s = "/backup/removeBackup"; boolean check;
        DBPage positiveBackup = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .clickCreateDB();
        positiveBackup.capture(s);
        BackUpPage bp = positiveBackup.clickBackupButton();
        bp.posCreateBackup(BACKUP_NAME1); bp.capture(s);
        bp.removeBackup();
        check = bp.removeObservationElementIsDisplayed();
        Assert.assertTrue(check);
    }
}
