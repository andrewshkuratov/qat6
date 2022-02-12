package com.epam.sum_university.pageobject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BasePage {
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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
        File dir = new File("src/test/resources/screenshots/"
                + s
                + "/");
        String path = "src/test/resources/screenshots/"
                + s
                + "/"
                + formatDate
                + ".png";
        FileUtils.copyFile(source, new File(path));
    }
}
