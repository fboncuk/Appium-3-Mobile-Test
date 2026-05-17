package base;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // AndroidDriver tipinde bir driver referansı tanımlanır
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() {

        // Driver initialization (başlatma / setup)
        DriverManager.initDriver();
        driver = DriverManager.getDriver(); // Driver retrieval / Singleton access

        // Şu anda Driver oluşturulup hazır hale getirildi:
        // 1. AndroidDriver / AppiumDriver oluşturuldu
        // 2. capabilities set edildi
        // 3. Appium session başlatıldı

        // Driver neden burada yazıldı?
        // 1. Her test class içinde new driver yazmamak
        // 2. Tek noktadan yönetmek (centralized control)
        // 3. Parallel run için ThreadLocal kullanmak
        // 4. Session yönetimini kolaylaştırmak


    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}