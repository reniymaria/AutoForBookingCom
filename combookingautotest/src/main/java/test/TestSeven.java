package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(util.TestngListener.class)
public class TestSeven extends BaseTest {

    /**
     *Steps:
     * 1. Open booking.com
     * 2. Change language to Deutch
     * 3. Open google
     * 4. Check that title is displayed in deutch
     *
     * Expected Result: Language is correct
     *
     */
    @Test
    public void CheckLanguage() {

  /*
        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(someElement)
                .moveToElement(otherElement)
                .release(otherElement)
                .build();

        dragAndDrop.perform();
        */
    }
}
