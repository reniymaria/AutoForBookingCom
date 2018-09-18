package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AviaTickets extends Page {

    private static final String MINSK = "Minsk";
    private static final String MOW = "MOW";
    private String strDateFormat = "dd.MM.yyyy";
    private static final Logger log = LoggerFactory.getLogger(AviaTickets.class);

    @FindBy(name = "origin")
    public WebElement fromField;

    @FindBy(name = "destination")
    public WebElement toField;

    @FindBy(xpath = "//*[contains(@id, 'submit')]")
    public WebElement submit;

    @FindBy(xpath = "//*[contains(@id, 'depart-input')]")
    public WebElement fromDate;

    @FindBy(xpath = "//*[contains(@id, 'return-input')]")
    public WebElement toDate;


    public AviaTickets enterFromToDestination() {
        log.debug("Enter destination in the fields");
        sendChar(fromField, MINSK);
        sendChar(toField, MOW);
        return this;
    }

    public AviaTickets enterDates() {
        log.debug("Enter dates in the fields");
        sendChar(fromDate, getDay(1));
        sendChar(toDate, getDay(7));
        return this;
    }

    public ResultAviaTickets search() throws Exception {
        log.debug("Submit form");
        submit.click();
        return MyPageFactory.getPage(driver, ResultAviaTickets.class);
    }

    private String getDay(int days) {
        log.debug("Get day from current day + days");
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        Date dt = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, days);
        dt = c.getTime();
        return objSDF.format(dt);
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


    void tryToOpen(){
        log.debug("Try to open AviaTickets page");
    }
}
