package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.MyPageFactory;
import pages.StartPage;
import util.PropertiesReader;


public class BaseTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);


    public static WebDriverWait getWait() {
        return wait;
    }

    @BeforeTest
    public void setUp() {
        System.setProperty(PropertiesReader.getWebDriver(), PropertiesReader.getUrlWebDriver());
        ChromeOptions options = new ChromeOptions();
        log.debug("Set language for Browser as ru-Ru");
        options.addArguments("--lang=ru-RU");
        log.debug("Start driver");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, PropertiesReader.getTimeOut());

    }

   // @AfterTest
 //   public void driverClose() throws InterruptedException {
  //      Thread.sleep(4000);
  //      driver.quit();
  //  }


    public static WebDriver getDriver() {
        return driver;
    }

    public StartPage goToMainPage() throws Exception {
        log.info(String.format("Open page by link: %s", PropertiesReader.getURL()));
        driver.get(PropertiesReader.getURL());
        return MyPageFactory.getPage(driver, StartPage.class);

    }
}
