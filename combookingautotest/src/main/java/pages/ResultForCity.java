package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultForCity extends Page {


    private static int firstResult;
    private static int secondResult;

    @FindBy(id = "results_prev_next")
    public WebElement results;

    @FindBy(xpath = "//h1[@class='sorth1']")
    public WebElement resSort;

    @FindBy(xpath = "//a[@data-id='class-4']")
    public WebElement stars;

    @FindBy(xpath = "//a[@data-id='hotelfacility-107']")
    public WebElement wifi;

    public ResultForCity firstResult() {

        String resultData = results.getText();
        String[] res = resultData.split(" ");
        firstResult = Integer.parseInt(res[0]);

        return this;
    }


    public ResultForCity checkFiltr() {
        stars.click();
        wifi.click();

        return this;
    }

    public ResultForCity secondResult() throws InterruptedException {
        Thread.sleep(2000);
        String resData = resSort.getText();
        String[] res = resData.split(" ");
        secondResult = Integer.parseInt(res[2]);

        return this;
    }

    public boolean compare() {

        return secondResult < firstResult;
    }


    void tryToOpen() throws Exception {


    }
}
