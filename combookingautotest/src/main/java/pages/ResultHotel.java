package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultHotel extends Page {

    private static final Logger log = LoggerFactory.getLogger(ResultHotel.class);


    @FindBy(css = "#results_prev_next > p")
    public WebElement result;


    public int numberOfResults() throws InterruptedException {
        Thread.sleep(2000);
        log.debug("Find result");
        String resultData = result.getText();
        String[] res = resultData.split(" ");
        return Integer.parseInt(res[2]);
    }


    void tryToOpen() {

    }
}
