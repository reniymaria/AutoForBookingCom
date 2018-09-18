package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.PropertiesReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class StartPage extends Page {

    private static final Logger log = LoggerFactory.getLogger(StartPage.class);
    private static final String WARSAW = "Warsaw";

    @FindBy(id = "ss")
    public WebElement destination;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/button")
    public WebElement calendarFrom;

    @FindBy(css = ".sb-searchbox__button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[1]")
    public WebElement aviaTickets;

    @FindBy(css = "#cross-product-bar > div > a:nth-child(3) > span")
    public WebElement rentCarLink;

    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[3]")
    public WebElement taxyRentLink;

    @FindBy(css = "#basiclayout > div.promotion-postcards-list > div:nth-child(1) > div:nth-child(1) ")
    public WebElement firstPostcard;

    @FindBy(css = "#b_tt_holder_1")
    public WebElement language;

    @FindBy(xpath = "//*[@data-title='Выберите язык']")
    public WebElement languageHover;

    @FindBy(xpath = "//*[@id='current_language_foldout']/div[2]/div/ul[1]/li[3]/a/span[2]")
    public WebElement de;

    @FindBy(xpath = "//*[@class='sb-searchbox__title-text']")
    public WebElement titleDe;


    public StartPage changeLanguage() {
        log.debug("Change language");
        Actions builder = new Actions(driver);
        builder.moveToElement(languageHover).build().perform();
        language.click();
        de.click();
        return this;
    }

    public boolean checkLanguage() {
        log.debug("Check the language of browser");
        String result = titleDe.getText();
        String textDE = "Finden Sie Angebote für jede Jahreszeit";
        return result.equals(textDE);
    }


    public StartPage enterDestination() {
        log.debug("Enter destination");
        destination.sendKeys(WARSAW);
        return this;
    }

    public ResultForCity openPostcard() throws Exception {
        log.debug("Open first city");
        firstPostcard.click();
        return MyPageFactory.getPage(driver, ResultForCity.class);
    }

    public ResultHotel clickSearch() throws Exception {
        log.debug("Click search for hotel");
        searchButton.click();
        return MyPageFactory.getPage(driver, ResultHotel.class);
    }

    public AviaTickets clickAviaLink() throws Exception {
        log.debug("Click search for Avia tickets");
        aviaTickets.click();
        windowNewOpened();
        return MyPageFactory.getPage(driver, AviaTickets.class);
    }

    public RentCar clickRentCar() throws Exception {
        log.debug("Click search for rent of the car");
        rentCarLink.click();
        windowNewOpened();
        return MyPageFactory.getPage(driver, RentCar.class);
    }


    public TaxyRent clickRentTaxy() throws Exception {
        log.debug("Click search for rent of a taxy");
        taxyRentLink.click();
        windowNewOpened();
        return MyPageFactory.getPage(driver, TaxyRent.class);
    }

    private void windowNewOpened() {
        log.debug("Switch between tabs");
        List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        // Uncomment code below if chrome is opened with extra data tab
       // driver.close();
       // driver.switchTo().window(tabs2.get(2));
    }


    public StartPage setDate() throws InterruptedException {
        log.debug("Set date for calendar");
        String oneDate = String.valueOf(getDay());
        calendarFrom.click();
        selectDayFromMultiDateCalendar(oneDate);
        return this;
    }


    private void selectDayFromMultiDateCalendar(String day)
            throws InterruptedException {

        WebElement dateFrom = driver.findElement(By.xpath("//*[@class='c2-day-inner'][text()='"
                + day + "']"));

        dateFrom.click();
        Thread.sleep(2000);

    }


    private int getDay() {
        int next;
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.add(Calendar.DATE, 1);
        next = calendar.get(Calendar.DATE);
        return next;
    }


    @Override
    void tryToOpen(){
        log.debug("Open main page");
        driver.get(PropertiesReader.getURL());
    }
}