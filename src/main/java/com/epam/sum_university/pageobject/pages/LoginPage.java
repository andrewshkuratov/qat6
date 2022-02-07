package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.enumeration.SupportedBrowsers;
import com.epam.sum_university.pageobject.BasePage;
import com.epam.sum_university.properties.conventors.SupportedBrowserConverter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LoginPage extends BasePage {
    @FindBy(name = "login")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement pass;

    @FindBy(xpath = "//span[@id='basic-addon2']")
    private WebElement unmaskButton;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible fade show\"]")
    private WebElement errorLogin;

    @FindBy(xpath = "//a[@href=\"/login/reset-password\"]")
    private WebElement forgotPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage open() {
        webDriver.get("https://elephant.tss2021.site/login");
        return this;
    }

    public LoginPage enterPass(String pass){
        this.pass = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOf( this.pass));

        this.pass.sendKeys(pass);
        return new LoginPage(webDriver);
    }
    public HomePage login(String username, String pass){
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        loginButton.click();
        return new HomePage(webDriver);
    }

    public LoginPage clickUnmask() {
        unmaskButton.click();
        return new LoginPage(webDriver);
    }

    public String getTypeValue() {
        String arr;
        arr=pass.getAttribute("type");
        return arr;
    }

    public LoginPage negLogin(String username, String pass) {
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        loginButton.click();
        return new LoginPage(webDriver);
    }

    public boolean existErrorLogin() {
        return errorLogin.isDisplayed();
    }

    public ResetPasswordPage forgotPassword()
    {
        Actions act = new Actions(webDriver);
        act.moveToElement(forgotPassword).click();
        return new ResetPasswordPage(webDriver);
    }

    public LoginPage openHttp() {
        webDriver.get("http://elephant.tss2021.site/login");
        return this;
    }

}
