package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResetPasswordPage extends BasePage{

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement emailNew;

    @FindBy(xpath = "//button[@class='btn']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class=" +
            "\"alert alert-success alert-dismissible fade show\"]")
    private WebElement emailMessage;

    public ResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResetPasswordPage reset(String email) {
        this.emailNew.sendKeys(email);
        sendButton.click();
        return new ResetPasswordPage(webDriver);
    }

    public boolean findMessage() {
        emailMessage = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOf(emailMessage));

        return emailMessage.isDisplayed();
    }
}
