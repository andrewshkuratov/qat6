package com.epam.sum_university.invoker.implementations;

import com.epam.sum_university.invoker.WebDriverInvoker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LocalEdgeInvoker implements WebDriverInvoker {
    @Override
    public WebDriver invokeWebDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
