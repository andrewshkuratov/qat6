package com.epam.sum_university.properties.conventors;

import com.epam.sum_university.enumeration.SupportedBrowsers;

import static com.epam.sum_university.enumeration.SupportedBrowsers.*;

public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowserName) {
        return switch(webBrowserName) {
            case "local_chrome" -> LOCAL_CHROME;
            case "local_firefox" -> LOCAL_FIREFOX;
            case "local_edge" -> LOCAL_EDGE;
            default -> throw new IllegalArgumentException();
        };
    }
}
