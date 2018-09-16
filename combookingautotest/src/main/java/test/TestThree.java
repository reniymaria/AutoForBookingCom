package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestThree extends BaseTest {


    /**
     * Steps:
     * 1. Open booking.com
     * 2. Click Rent a car link
     * 3. Enter Country, City and Place
     * 4. Select Date from and To
     * 5. Click Search
     *
     * Expected Result: Results are found
     */
    @Test
    public void RentCar() throws Exception {

        Boolean result =
                goToMainPage().
                        clickRentCar()
                        .enterFields()
                        .enterDates()
                        .submit()
                        .resultsIsFound();
        Assert.assertTrue(result == true, "Nothing is found");
    }
}
