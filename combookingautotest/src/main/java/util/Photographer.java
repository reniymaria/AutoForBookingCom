package util;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Photographer {

    private static String SNAPSHOTS_FOLDER = "snapshot";
    private final static Logger log = LoggerFactory.getLogger(Photographer.class);

    private static String getSnapshotName(String driverCommand) {

        File folder = new File(SNAPSHOTS_FOLDER);
        if (!folder.exists()) {
            try {
                folder.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String timestamp = nowAsString("yyyyMMdd_HHmmss");
        return folder.getAbsolutePath() + "/" + timestamp + "_" + driverCommand;
    }

    private static String nowAsString(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }

    public static void doScreenshot(String caseName) {
        String filename = getSnapshotName(caseName) + ".png";
        File scrFile = ((TakesScreenshot) BaseTest.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filename));
        } catch (IOException e) {
            log.error(String.format("Error copy screenshot file from %s to %s",
                    scrFile.getAbsolutePath(), filename));
        }
    }


}
