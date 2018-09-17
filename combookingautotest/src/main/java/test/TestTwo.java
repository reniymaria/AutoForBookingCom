package test;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(util.TestngListener.class)
public class TestTwo extends BaseTest {

    /**
     * Steps:
     * 1. Open booking.com
     * 2. Click AviaTickets link
     * 3. Enter from Minsk To Moskow
     * 4. Enter Dates Nearest week
     * 5. Click Search
     *
     * Expected Result: More than 2 results are displayed
     */
    @Test
    public void FindAviaTickets() throws Exception {

        int results =
                goToMainPage()
                        .clickAviaLink()
                        .enterFromToDestination()
                        .enterDates()
                        .search()
                        .displayedAviaTickets();
        Assert.assertTrue(results > 2, "Not enough avia tickets are found");
    }
}
