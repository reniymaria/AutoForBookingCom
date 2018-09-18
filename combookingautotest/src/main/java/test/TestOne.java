package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(util.TestngListener.class)
public class TestOne extends BaseTest {

    /**
     * Steps:
     * 1. Open booking.com
     * 2. Enter "Warsaw" to destination field
     * 3. Select dates from next day plus 1 day
     * 4. Click "Check prices" button
     * Expected Result: More than 2 results are displayed
     */

    @Test
    public void FindHotel() throws Exception {

        int results = goToMainPage()
                .enterDestination()
                .setDate()
                .clickSearch().numberOfResults();
        Assert.assertTrue(results > 2, "Not enough results are found");
    }
}

