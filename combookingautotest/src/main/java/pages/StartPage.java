package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PropertiesReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class StartPage extends Page {

    public static final String WARSAW = "Warsaw";

    @FindBy(id = "ss")
    public WebElement destination;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/button")
    public WebElement calendarFrom;

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

    @FindBy(css = "#basiclayout > div.promotion-postcards-list > div:nth-child(1) > div:nth-child(1) ")
    public WebElement firstPostcard;


    public StartPage enterDestination() {
        destination.sendKeys(WARSAW);
        return this;
    }

    public ResultForCity openPostcard() throws Exception {
        firstPostcard.click();
        return MyPageFactory.getPage(driver, ResultForCity.class);
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
        String secondDate = String.valueOf(getNextDay());
        calendarFrom.click();
        selectDayFromMultiDateCalendar(oneDate, secondDate);

        return this;
    }


    private void selectDayFromMultiDateCalendar(String day, String day2)
            throws InterruptedException {

        WebElement dateFrom = driver.findElement(By.xpath("//*[@class='c2-day-inner'][text()='"
                + day + "']"));

        dateFrom.click();
        Thread.sleep(2000);


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