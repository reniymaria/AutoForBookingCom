package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultRentCar extends Page {

    @FindBy(xpath = "//*[@id=\"partner-booking-cars\"]/div[6]/div/div[2]/div[2]/div")
    public WebElement carsResult;

    public boolean resultsIsFound() {

        return carsResult.isDisplayed();
    }


    void tryToOpen() throws Exception {

    }
}
