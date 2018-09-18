package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ResultAviaTickets extends Page {

    private static final Logger log = LoggerFactory.getLogger(ResultAviaTickets.class);

    @FindBy(xpath = "//*[contains(@id, 'count')]/span[1]")
    public WebElement result;


    public int displayedAviaTickets() {
        log.debug("Check if avia tickets are displayed");
        int res = Integer.parseInt(result.getText());
        return res;
    }

    void tryToOpen() {
        log.debug("Try to open Avia Tickets result page");
    }
}
