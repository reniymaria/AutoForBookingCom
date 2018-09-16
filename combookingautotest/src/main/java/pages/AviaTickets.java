package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AviaTickets extends Page {

    private String strDateFormat = "dd.MM.yyyy";

    @FindBy(name= "origin")
    public WebElement fromField;

    @FindBy(name = "destination")
    public WebElement toField;

    @FindBy(xpath = "//*[contains(@id, 'submit')]")
    public WebElement submit;

    @FindBy(xpath = "//*[contains(@id, 'depart-input')]")
    public WebElement fromDate;

    @FindBy(xpath = "//*[contains(@id, 'return-input')]")
    public WebElement toDate;


    public AviaTickets enterFromToDestination(){
        sendChar(fromField, "Minsk");
        sendChar(toField, "MOW");
        return this;
    }

    public  AviaTickets enterDates(){
        sendChar(fromDate,getDay(1));
        sendChar(toDate, getDay(7));
        return this;
    }

    public ResultAviaTickets search() throws Exception {
        submit.click();
        return MyPageFactory.getPage(driver, ResultAviaTickets.class);
    }

    private String getDay(int days) {

        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        Date dt = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, days);
        dt = c.getTime();
        return objSDF.format(dt);
    }


    private void sendChar(WebElement element, String value)
    {
        element.clear();
        element.click();

        for (int i = 0; i < value.length(); i++){
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
        element.sendKeys(Keys.RETURN);
    }


    void tryToOpen() throws Exception {

    }
}
