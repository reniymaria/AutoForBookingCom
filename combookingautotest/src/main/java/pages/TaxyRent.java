package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaxyRent extends Page {

    @FindBy(id = "pickupLocation")
    public WebElement pickupLocation;

    @FindBy(id = "dropoffLocation")
    public WebElement dropoffLocation;


    public TaxyRent enterLocation(){

        sendChar(pickupLocation,"ELS");
        sendChar(dropoffLocation,"ELS");
        return this;
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
