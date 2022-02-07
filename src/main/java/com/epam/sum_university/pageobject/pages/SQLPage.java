package com.epam.sum_university.pageobject.pages;

import com.epam.sum_university.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SQLPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"editor\"]")
    private WebElement console;

    @FindBy(xpath = "//button[@class='btn']")
    private WebElement runBtn;

    @FindBy(xpath = "//p[contains(text(),'result')]")
    private WebElement result;


    public SQLPage enterCommmand(String s){
        console.sendKeys(s);
        return new SQLPage(webDriver);
    }

    public SQLPage runCommand(){
        runBtn.click();
        return new SQLPage(webDriver);
    }

    protected SQLPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean resultSQL()
    {
        return result.isDisplayed();
    }
}
