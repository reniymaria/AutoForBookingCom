package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(util.TestngListener.class)
public class TestSeven extends BaseTest {

    /**
     * Steps:
     * 1. Open booking.com
     * 2. Change language to Deutsch
     * 3. Open google
     * 4. Check that title is displayed in Deutsch
     * Expected Result: Language is correct
     */

    @Test
    public void CheckLanguage() throws Exception {

        Boolean res = goToMainPage()
                .changeLanguage()
                .checkLanguage();

        Assert.assertTrue(res, "Language is not changed");

    }
}
