package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultTaxyRent extends Page {


    @FindBy(xpath = "//*[@data-test='rw-search-result__item-select']")
    public WebElement result;

    public boolean resultSearch() {
        return result.isDisplayed();
    }

    void tryToOpen() throws Exception {

    }
}
