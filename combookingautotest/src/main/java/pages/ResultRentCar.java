package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultRentCar extends Page {

    private static final Logger log = LoggerFactory.getLogger(ResultRentCar.class);


    @FindBy(xpath = "//*[@id='partner-booking-cars']")
    public WebElement carsResult;

    public boolean resultsIsFound() {
        log.debug("Result is displayed");
        return carsResult.isDisplayed();
    }


    void tryToOpen(){
        log.debug("Open result for rent car");
    }
}
