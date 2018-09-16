package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultAviaTickets extends Page {


    @FindBy(xpath = "//*[contains(@id, 'count')]/span[1]")
    WebElement result;


    public int displayedAviaTickets() {
        int res = Integer.parseInt(result.getText());
        return res;
    }

    void tryToOpen() throws Exception {

    }
}
