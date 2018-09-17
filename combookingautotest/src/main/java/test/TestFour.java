package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(util.TestngListener.class)
public class TestFour extends BaseTest {

    /**
     * Steps:
     * 1. Open booking.com
     * 2. Click Taxy Rent link
     * 3. Enter Place
     * 4. Date and Time
     * 5. Click "Search" button
     * Expected Result: More than 2 results are displayed
     */
    @Test
    public void RentTaxyFromToAirport() throws Exception {

        Boolean result = goToMainPage()
                .clickRentTaxy()
                .enterLocation()
                .enterDate()
                .enterTime()
                .search()
                .resultSearch();
        Assert.assertTrue(result, "Nothing is found");
    }
}
