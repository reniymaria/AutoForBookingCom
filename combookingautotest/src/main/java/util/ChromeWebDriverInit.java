package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriverInit {

    private static WebDriver driver;

    private ChromeWebDriverInit() {

    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(PropertiesReader.getWebDriver(), PropertiesReader.getUrlWebDriver());
            driver = new ChromeDriver();

        }
        return driver;
    }

}

