package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(util.TestngListener.class)
public class TestSix extends BaseTest {

    /**
     * Steps:
     * 1. Open booking.com
     * 2. Open FirstCity
     * 3. Open Map
     * 4. Click +
     * 5. Make screenshot (Screenshot can be found in snapshot folder)
     * 6. Click -
     * 7. Make screenshot
     * Expected Result: User can resize map
     */
    @Test
    public void CheckFiltersForFlights() throws Exception {

        goToMainPage()
                .openPostcard()
                .openMap()
                .resizeMap();

    }
}
