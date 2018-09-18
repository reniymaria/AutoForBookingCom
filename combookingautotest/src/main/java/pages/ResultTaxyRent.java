package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultTaxyRent extends Page {

    private static final Logger log = LoggerFactory.getLogger(ResultTaxyRent.class);


    @FindBy(xpath = "//*[@data-test='rw-search-result__item-select']")
    public WebElement result;

    public boolean resultSearch() {
        log.debug("Result of search for rent a taxy");
        return result.isDisplayed();
    }

    void tryToOpen(){
        log.debug("Open result for rent a taxy");
    }
}
