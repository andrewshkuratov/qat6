package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class SignInPage extends BasePage {
    @FindBy(name = "login")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement pass;

    @FindBy(name = "conformation")
    private WebElement confPass;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement signInButton;

    @FindBy(xpath = "//p[contains(text(),'The user with such email address has been already registered. Please fill out another email address')]")
    private WebElement errorExistEmail;

    @FindBy(xpath = "//img[@src=\"/images/hero.svg\"]")
    private WebElement logoSignIn;

    @FindBy(xpath = "//p[contains(text(),'Please fill out the form once again')]")
    private WebElement message;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignInPage open() {
        webDriver.get("https://elephant.tss2021.site/registration");
        return this;
    }

    public HomePage signIn(String username, String pass, String pass1) {
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        this.confPass.sendKeys(pass1);
        signInButton.click();

        return new HomePage(webDriver);
    }

    public SignInPage negSignIn(String username, String pass, String pass1) {
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        this.confPass.sendKeys(pass1);
        signInButton.click();

        return new SignInPage(webDriver);
    }

    public boolean existErrorSignIn() {
        errorExistEmail = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOf(errorExistEmail));
        return errorExistEmail.isDisplayed();
    }

    public boolean fillError() {
        message = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOf(message));
        return message.isDisplayed();
    }

    public boolean logoSignIn() {
        return logoSignIn.isDisplayed();
    }

}
