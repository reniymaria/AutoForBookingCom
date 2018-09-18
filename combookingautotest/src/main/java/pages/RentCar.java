package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RentCar extends Page {

    private static final Logger log = LoggerFactory.getLogger(RentCar.class);

    @FindBy(xpath = "//*[@id=\"pu-country\"]")
    public WebElement country;

    @FindBy(xpath = "//*[@id=\"pu-city\"]")
    public WebElement city;

    @FindBy(xpath = "//*[@id=\"SearchResultsForm\"]/div/div[1]/fieldset[1]/div[1]/span")
    public WebElement calendarFrom;

    @FindBy(xpath = "//*[@id=\"dateselect-calendar\"]/div/table/tbody/tr[5]/td[1]")
    public WebElement dateFrom;

    @FindBy(xpath = "//*[@id=\"dateselect-calendar\"]/div/table/tbody/tr[5]/td[5]")
    public WebElement dateTo;

    @FindBy(id = "formsubmit")
    public WebElement submit;


    public RentCar enterFields() throws InterruptedException {
        log.debug("Enter country and city");
        waitForLoad(driver);
        Select dropdownCountry = new Select(country);
        dropdownCountry.selectByIndex(3);
        Thread.sleep(2000);
        Select dropdownCity = new Select(city);
        dropdownCity.selectByIndex(3);
        return this;
    }

    public RentCar enterDates() throws InterruptedException {
        log.debug("Enter dates");
        calendarFrom.click();
        Thread.sleep(2000);
        dateFrom.click();
        dateTo.click();
        Thread.sleep(2000);
        return this;
    }


    public ResultRentCar submit() throws Exception {
        log.debug("Submit form");
        submit.click();
        return MyPageFactory.getPage(driver, ResultRentCar.class);
    }

    void tryToOpen() {
        log.debug("Try to open Rent Car page");
    }
}
