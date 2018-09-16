package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesReader {

    private static final Logger log = LoggerFactory.getLogger(PropertiesReader.class);
    private static Properties properties;

    private static void read() {

        if (properties == null) {
            properties = new Properties();
        }

        InputStream input = null;

        try {

            String filename = "file.properties";
            input = PropertiesReader.class.getClassLoader().getResourceAsStream(filename);
            try {
                if (input == null) {
                    System.out.println("Sorry, unable to find " + filename);
                    return;
                }
            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(e.toString());

                }
            }
        }
    }

    public static String getURL() {
        read();
        return properties.getProperty("URL");
    }

    public static int getTimeOut() {
        read();
        return Integer.parseInt(properties.getProperty("TIMEOUT"));
    }

    public static String getWebDriver() {
        read();
        return properties.getProperty("WEBDRIVER");
    }

    public static String getUrlWebDriver() {
        read();
        return properties.getProperty("URLWEBDRIVER");
    }
}


