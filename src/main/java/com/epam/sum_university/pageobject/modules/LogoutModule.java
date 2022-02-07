package com.epam.sum_university.pageobject.modules;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutModule extends BasePage {
    private WebElement logoutButton;

    public LogoutModule(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean getLoginField() {
        logoutButton = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"floatingInput\"]")));
        return logoutButton.isDisplayed();
    }
}
