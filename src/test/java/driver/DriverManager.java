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
            // Appium Java Client (Appium Java SDK) kütüphanesinin bir parçası olarak
            // Bu kod boş bir options nesnesi oluşturur.
            // Appium 1'de DesiredCapabilities caps = new DesiredCapabilities() karşılığı

            // Testlerin hangi cihazda, hangi uygulamada, nasıl çalışacağı tanımlanır
            options.setDeviceName(ConfigReader.get("deviceName"));
            options.setPlatformName(ConfigReader.get("platformName"));
            options.setPlatformVersion(ConfigReader.get("platformVersion"));
            options.setAutomationName(ConfigReader.get("automationName"));
            options.setUdid(ConfigReader.get("udid"));
            // options.setApp(ConfigReader.get("app")); uygulamayı yüklemek için bir kez kullanılır.
            options.setAppPackage(ConfigReader.get("appPackage"));
            options.setAppActivity(ConfigReader.get("appActivity"));

            // Aşağıdaki kod Appium’da gerçek driver (session) oluşturma noktasıdır
            // Oluşturulan AndroidDriver nesnesi "driver" değişkenine atanır
            // Yani artık testlerde kullanılacak “aktif driver” budur
            driver = new AndroidDriver(
                    new URL(ConfigReader.get("appiumURL")),
                    options
            );
            // ConfigReader.get("appiumURL") → config dosyasından Appium server URL çeker
            // options: Desired Capabilities / Appium Options’tır.


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            // Driver bir element bulamazsa hemen fail vermez
            // 10 saniye boyunca tekrar tekrar dener bulursa devam eder
            // 10 saniye sonunda hâlâ bulamazsa exception atar


        } catch (Exception e) {
            throw new RuntimeException("Driver init failed", e);
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is null. Did you call initDriver()?");
        }
        return driver;

        // Bu metot, driver’ı güvenli şekilde geri döndürür (retrieve eder)
        // public →         her yerden erişilebilir
        // static →         sınıfa ait, obje oluşturmadan çağrılır (DriverManager.getDriver())
        // AndroidDriver →  geri döndürülecek tip
        // getDriver() →    driver’ı almak için kullanılan method

        // throw new IllegalStateException(...) Eğer driver yoksa programı bilinçli şekilde durdurur.

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}