package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultHotel extends Page {

    @FindBy(css = "#results_prev_next > p")
    WebElement result;

    public int numberOfResults() {
        String resultData = result.getText();
        String[] res = resultData.split(" ");
        return Integer.parseInt(res[2]);
    }


    void tryToOpen() throws Exception {

    }
}
