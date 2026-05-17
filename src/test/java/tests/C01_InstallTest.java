package tests;

import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccessibilityPage;
import pages.ApiDemosPage;
import utils.ConfigReader;

public class C01_InstallTest extends BaseTest {

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    AccessibilityPage accessibilityPage = new AccessibilityPage();

    // ApiDemos-debug_v6.0.10.apk uygulamasının telefona yüklendiği doğrulanır
    @Test
    public void verifyAppInstallAndLaunch() {

        String appPackage = ConfigReader.get("appPackage");

        // 1. App installed mi?
        boolean isInstalled = DriverManager.driver.isAppInstalled(appPackage);

        Assert.assertTrue(isInstalled, "App is NOT installed");

        // 2. App açık mı? (simple check)
        String actualPackage = DriverManager.driver.getCurrentPackage();

        Assert.assertEquals(actualPackage, appPackage);
    }

    // App ana sayfa açıldığı doğrulanır
    @Test
    public void verifyAppIsRunningAndHomeScreenVisible() {

        // 1. actual package kontrol
        String expectedPackage = ConfigReader.get("appPackage");
        String actualPackage = DriverManager.driver.getCurrentPackage();
        Assert.assertEquals(actualPackage, expectedPackage,
                "Wrong package opened");

        // 2. actual (current) activity kontrol (çok önemli)
        String actualActivity = DriverManager.driver.currentActivity();
        Assert.assertTrue(actualActivity.contains("ApiDemos"),
                "Wrong activity");

        // 3. temel element kontrol
        Assert.assertTrue(
                DriverManager.driver.findElement(apiDemosPage.accessibilityElement).isDisplayed(),
                "Home element not visible");

        // 4. ekstra check (source debug için)
        // System.out.println(DriverManager.driver.getPageSource());
    }

    // UI Element Görünürlük testi
    // Accessibility → Accessibility Node Provider ekranına git. Title görünürlüğünü test et
    @Test
    public void verifyAccessibilityNodeProviderVisibility () throws InterruptedException {

        // Accessibility tıklanır
        driver.findElement(apiDemosPage.accessibilityElement).click();
        // Accessibility Node Provider tıklanır
        driver.findElement(accessibilityPage.ANodeProviderElement).click();

        // Ekranda görülen yazı değişkene atanır
        String actualText1 = driver.findElement(accessibilityPage.ANodeProviderTextElement1).getText();

        // Ekrandaki yazıyı yazdıralım
        System.out.println("element 1 " + actualText1);

        // Eğer yazı "Enable TalkBack" içeriyorsa sayfa görünür demektir
        Assert.assertTrue(actualText1.contains("Enable TalkBack"));

    }




}