package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Photographer;

public class ResultForCity extends Page {

    private static final Logger log = LoggerFactory.getLogger(ResultForCity.class);
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

    @FindBy(id="map-header-cta")
    public WebElement map;

    @FindBy(xpath = "//*[@id=\"map_atlas_custom_zoom\"]/a[1]")
    public WebElement plus;

    @FindBy(xpath = "//*[@id=\"map_atlas_custom_zoom\"]/a[2]")
    public WebElement minus;

    public ResultForCity firstResult() {
        log.debug("Result for city");
        String resultData = results.getText();
        String[] res = resultData.split(" ");
        firstResult = Integer.parseInt(res[0]);

        return this;
    }

    public ResultForCity openMap() throws InterruptedException {
        log.debug("Open map");
        map.click();
        Thread.sleep(5000);
        return this;
    }

    public ResultForCity resizeMap(){
        log.debug("Enlarge map");
        plus.click();
        plus.click();
        Photographer.doScreenshot("Map resizedPlus");
        log.debug("Resize map");
        minus.click();
        minus.click();
        Photographer.doScreenshot("Map resizedMinus");
        return this;
    }

    public ResultForCity checkFiltr() {
        log.debug("Check filters");
        stars.click();
        wifi.click();

        return this;
    }

    public ResultForCity secondResult() {
        waitForLoad(driver);
        log.debug("Find second result");
        String resData = resSort.getText();
        String[] res = resData.split(" ");
        secondResult = Integer.parseInt(res[2]);

        return this;
    }

    public boolean compare() {
        log.debug("Compare results");
        return secondResult < firstResult;
    }


    void tryToOpen() {
        log.debug("Open Result for city page");
    }
}
