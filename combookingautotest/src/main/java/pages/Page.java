package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.BaseTest;

public abstract class Page {
    public WebDriver driver;
    public WebDriverWait wait = BaseTest.getWait();
    protected final Logger log = LoggerFactory.getLogger(Page.class);


    public boolean isOnThisPage(){
        return true;
    }

    abstract void tryToOpen() throws Exception;

}
