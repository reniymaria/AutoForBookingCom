package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaxyRent extends Page {

    private static final Logger log = LoggerFactory.getLogger(TaxyRent.class);
    private static final String FROM = "Moskow";
    private static final String TO = "DME";
    private static final String HOUR = "13";
    private static final String MIN = "30";


    @FindBy(id = "pickupLocation")
    public WebElement pickupLocation;

    @FindBy(id = "dropoffLocation")
    public WebElement dropoffLocation;

    @FindBy(xpath = "//*[@aria-label='pickup time input field']")
    public WebElement timeField;

    @FindBy(xpath = "//*[@aria-label='pickup date input field']")
    public WebElement dateField;

    //Here I could enter any date using method #selectDayFromMultiDateCalendar() StartPage.class
    @FindBy(xpath = "//a[@aria-label ='23, Сентябрь 2018']")
    public WebElement date;

    @FindBy(id = "pickupHour")
    public WebElement hour;

    @FindBy(id = "pickupMinute")
    public WebElement minute;

    @FindBy(xpath = "//*[@class='rw-time-picker__confirm']")
    public WebElement choice;

    @FindBy(name = "searchButton")
    public WebElement search;

    @FindBy(xpath = "//*[@class='rw-autocomplete__item-title']")
    public WebElement autocomplete;


    public TaxyRent enterLocation() {
        log.debug("Enter location");
        waitForLoad(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickupLocation")));
        sendChar(pickupLocation, FROM);
        autocomplete.click();
        sendChar(dropoffLocation, TO);
        autocomplete.click();
        return this;
    }


    private void sendChar(WebElement element, String value) {

        element.clear();
        element.click();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
        element.sendKeys(Keys.RETURN);
    }

    public TaxyRent enterDate() {
        log.debug("Enter date");
        dateField.click();
        date.click();

        return this;
    }

    public TaxyRent enterTime() {
        log.debug("Enter time");
        timeField.click();
        hour.sendKeys(HOUR);
        minute.sendKeys(MIN);
        choice.click();
        return this;
    }

    public ResultTaxyRent search() throws Exception {
        log.debug("Search for rent");
        search.click();
        return MyPageFactory.getPage(driver, ResultTaxyRent.class);
    }

    void tryToOpen(){
        log.debug("Open the taxy page");
    }
}
