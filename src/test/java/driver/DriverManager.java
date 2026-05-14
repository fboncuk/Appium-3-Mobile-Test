package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

import java.net.URL;
import java.time.Duration;

public class DriverManager {

    public static AndroidDriver driver;

    public static void initDriver() {

        try {
            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName(ConfigReader.get("platformName"));
            options.setDeviceName(ConfigReader.get("deviceName"));
            options.setUdid(ConfigReader.get("udid"));
            options.setApp(ConfigReader.get("appPath"));

            driver = new AndroidDriver(
                    new URL(ConfigReader.get("appiumURL")),
                    options
            );

        } catch (Exception e) {
            throw new RuntimeException("Driver init failed", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}