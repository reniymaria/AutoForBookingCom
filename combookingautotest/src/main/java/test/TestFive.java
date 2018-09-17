package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(util.TestngListener.class)
public class TestFive extends BaseTest {

    /**
     * Steps:
     * 1. Open booking.com
     * 2. Click first available city
     * 3. Remember number of results
     * 4. Enter Stars, Review Score, Facilities
     * Expected Result: Number of results reduced
     */
    @Test
    public void CheckFiltersForBooking() throws Exception {

        Boolean res = goToMainPage()
                .openPostcard()
                .firstResult()
                .checkFiltr()
                .secondResult()
                .compare();
        Assert.assertTrue(res, "Filters are not applied");
    }
}
