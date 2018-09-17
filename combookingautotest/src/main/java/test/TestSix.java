package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(util.TestngListener.class)
public class TestSix extends BaseTest {

    /**
     *Steps:
     * 1. Open booking.com
     * 2. Open FirstCity
     * 3. Open Map
     * 4. Drag map to south
     * 5. Make screenshot
     *
     * Expected Result: User can drag map
     *
     */
    @Test
    public void CheckFiltersForFlights() {

    }
}
