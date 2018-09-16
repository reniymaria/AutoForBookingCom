package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PropertiesReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class StartPage extends Page {

    @FindBy(id = "ss")
    public WebElement destination;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/button")
    public WebElement calendarFrom;

    @FindBy(xpath = "//*[@id=\"frm\"]//div[3]//div[1]/div/button")
    public WebElement calendarTo;

    @FindBy(css = ".sb-searchbox__button")
    public WebElement searchButton;

    @FindBy(className = "c2-day-inner")
    public List<WebElement> allDates;

    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[1]")
    public WebElement aviaTickets;

    @FindBy(css = "#cross-product-bar > div > a:nth-child(3) > span")
    public WebElement rentCarLink;

    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[3]")
    public WebElement taxyRentLink;


    public StartPage enterDestination() {
        destination.sendKeys("Warsaw");
        return this;
    }

    public ResultHotel clickSearch() throws Exception {

        searchButton.click();
        return MyPageFactory.getPage(driver, ResultHotel.class);
    }

    public AviaTickets clickAviaLink() throws Exception {
        aviaTickets.click();
        windowNewOpened();
        return MyPageFactory.getPage(driver, AviaTickets.class);
    }

    public RentCar clickRentCar() throws Exception {
        rentCarLink.click();
        windowNewOpened();
        return MyPageFactory.getPage(driver, RentCar.class);
    }

    public TaxyRent clickRentTaxy() throws Exception {

        taxyRentLink.click();
        windowNewOpened();
        return MyPageFactory.getPage(driver, TaxyRent.class);
    }

    private void windowNewOpened() {
        List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(2));
    }


    public StartPage setDate() throws InterruptedException {

        String oneDate = String.valueOf(getCurrentDay());
        String SecondDate = String.valueOf(getNextDay());
        calendarFrom.click();

        for (WebElement ele : allDates) {
            if (ele.getText().equals(oneDate)) {
                ele.click();
                Thread.sleep(500);
            }
        }
        for (WebElement elem : allDates) {
            if (elem.getText().equals(SecondDate)) {
                elem.click();
                break;
            }
        }
        return this;
    }


    private int getNextDay() {
        int next;
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(Calendar.DATE, 3);
        next = calendar.get(Calendar.DATE);
        return next;
    }

    private int getCurrentDay() {
        int next;
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(Calendar.DATE, 1);
        next = calendar.get(Calendar.DATE);
        return next;
    }


    @Override
    void tryToOpen() throws Exception {
        driver.get(PropertiesReader.getURL());
    }
}
