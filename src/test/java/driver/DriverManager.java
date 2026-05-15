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

            options.setDeviceName(ConfigReader.get("deviceName"));
            options.setPlatformName(ConfigReader.get("platformName"));
            options.setPlatformVersion(ConfigReader.get("platformVersion"));
            options.setAutomationName(ConfigReader.get("automationName"));
            options.setUdid(ConfigReader.get("udid"));
            // options.setApp(ConfigReader.get("app")); uygulamayı yüklemek için bir kez kullanılır.
            options.setAppPackage(ConfigReader.get("appPackage"));
            options.setAppActivity(ConfigReader.get("appActivity"));

            driver = new AndroidDriver(
                    new URL(ConfigReader.get("appiumURL")),
                    options
            );

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            throw new RuntimeException("Driver init failed", e);
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is null. Did you call initDriver()?");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}