package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import com.epam.sum_university.pageobject.modules.LogoutModule;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomePage extends BasePage {
    @FindBy(xpath = "//summary[@class=\"Header-link\"]/img")
    private WebElement profileDropDownButton;

    @FindBy(xpath = "//div[@class='container shadow border p-5']")
    private WebElement message;

    @FindBy(xpath = "//span[@class=\"text-nowrap\"]/a")
    private WebElement userInformationLabel;

    @FindBy(xpath = "//div/a[@href=\"/logout\"]")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement createDB;

    @FindBy(xpath = "//button[@class='w-100 btn disabled']")
    private WebElement createDBDisable;

    //button[@class='w-100 btn']

    @FindBy(xpath = "//li[@class='nav-item']/a[@class='nav-link']")
    private WebElement userProfileButton;

    @FindBy(xpath = "//button[@class='btn']")
    private WebElement deletedb;

    @FindBy(xpath = "/html/body/div/div/main/div[4]/div/div[2]/p")
    private WebElement noDBMessage;

    //p[text()='В даний час у вас немає жодної бази даних']

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserInformationLabel() {
        return userInformationLabel.getText();
    }

    public LogoutModule logout() {
        logoutButton.click();
        return new LogoutModule(webDriver);
    }

    public ProfilePage clickProfileButton() {
        userProfileButton.click();
        return new ProfilePage(webDriver);
    }

    public DBPage clickCreateDB() {
        createDB = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOf(createDB));
        Actions act = new Actions(webDriver);
        act.moveToElement(createDB).click();
        return new DBPage(webDriver);
    }

    public boolean DeleteDB() {
        deletedb.click();
        return noDBMessage.isDisplayed();
    }

    public boolean createDBIsClickable() {
        return createDBDisable.isDisplayed();
    }

    public boolean messageIsDisplayed() {
        return message.isDisplayed();
    }

    public void cleanDir(String s) throws IOException {
        File dir = new File("src/test/resources/screenshots/" + s + "/");
        FileUtils.cleanDirectory(dir);
    }
    public void capture(String s) throws IOException {
        File source = ((TakesScreenshot) webDriver)
                .getScreenshotAs(OutputType.FILE);
        LocalDateTime time = LocalDateTime.now();
        String formatDate = time.format(DateTimeFormatter
                .ofPattern("dd_MM_yy-HH_mm_ss"));
        File dir = new File(
                "src/test/resources/screenshots/" + s + "/");
        String path = "src/test/resources/screenshots/"
                + s
                + "/"
                + formatDate
                + ".png";
        FileUtils.copyFile(source, new File(path));
    }
}
