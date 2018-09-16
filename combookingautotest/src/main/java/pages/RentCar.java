package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import java.util.List;


public class RentCar extends Page {

    @FindBy(xpath = "//*[@id=\"pu-country\"]")
    public WebElement country;

    @FindBy(xpath = "//*[@id=\"pu-city\"]")
    public WebElement city;

    @FindBy(xpath = "//*[@id=\"dateselect-calendar\"]//tr/td")
    public List<WebElement> allDates;

    @FindBy(xpath = "//*[@id=\"SearchResultsForm\"]/div/div[1]/fieldset[1]/div[1]/span")
    public WebElement calendarFrom;

    @FindBy(xpath = "//*[@id=\"SearchResultsForm\"]/div/div[1]/fieldset[2]/div[1]/span")
    public WebElement calendarTo;

    @FindBy(xpath = "//*[@id=\"dateselect-calendar\"]/div/table/tbody/tr[5]/td[2]/a")
    public WebElement dateFrom;

    @FindBy(xpath = "//*[@id=\"dateselect-calendar\"]/div/table/tbody/tr[5]/td[4]/a")
    public WebElement dateTo;

    @FindBy(id = "formsubmit")
    public WebElement submit;


    public RentCar enterFields() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pu-country\"]")));
        Select dropdownCountry = new Select(country);
        dropdownCountry.selectByIndex(3);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pu-city\"]")));
        Select dropdownCity = new Select(city);
        dropdownCity.selectByIndex(3);

        return this;
    }

    public RentCar enterDates() {

        calendarFrom.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dateselect-calendar\"]/div/table/tbody/tr[5]/td[2]/a")));
        dateFrom.click();
        calendarTo.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dateselect-calendar\"]/div/table/tbody/tr[5]/td[4]/a")));
        dateTo.click();

        return this;
    }


    public ResultRentCar submit() throws Exception {
        submit.click();
        return MyPageFactory.getPage(driver, ResultRentCar.class);
    }

    void tryToOpen() throws Exception {

    }
}
