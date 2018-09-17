package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MyPageFactory;
import pages.StartPage;
import util.ChromeWebDriverInit;
import util.PropertiesReader;


public class BaseTest {
    protected WebDriver driver;
    private static WebDriverWait wait;
    private String baseUrl;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    public static WebDriverWait getWait() {
        return wait;
    }

    @BeforeTest
    public void setUp() {
        driver = ChromeWebDriverInit.getDriver();
        wait = new WebDriverWait(driver, PropertiesReader.getTimeOut());
        log.debug("Start driver");
        baseUrl = PropertiesReader.getURL();


    }

    @AfterTest
    public void driverClose() {
        driver.quit();
    }

    public StartPage goToMainPage() throws Exception {
        log.info(String.format("Open page by link: %s", baseUrl));
        driver.get(baseUrl);
        return MyPageFactory.getPage(driver, StartPage.class);

    }


}
