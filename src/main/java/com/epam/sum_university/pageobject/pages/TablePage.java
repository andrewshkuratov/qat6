package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablePage extends BasePage
{
    @FindBy(xpath = "/html/body/div/div/main/div/h1/a[1]")
    private WebElement tableLabel;

    @FindBy(xpath = "//table")
    private WebElement dbExplCheck;
    public TablePage(WebDriver webDriver) {
        super(webDriver);
    }
    public TablePage сlickdbTableName () {
    tableLabel.click();
    return new TablePage(webDriver);
}

    public boolean positiveCheckDisplayTablenInfo() {
        dbExplCheck = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOf(dbExplCheck));
        return dbExplCheck.isDisplayed();
    }

    public boolean positiveCheckDBExplorerPage() {
        dbExplCheck = new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.visibilityOf(dbExplCheck));
        return dbExplCheck.isDisplayed();
    }
    public boolean positiveCheckDisplayTableData() {
        return tableLabel.isDisplayed();
    }
}
