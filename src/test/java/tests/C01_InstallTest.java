package tests;

import base.BaseTest;
import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApiDemosPage;
import utils.ConfigReader;

public class C01_InstallTest extends BaseTest {

    ApiDemosPage page = new ApiDemosPage();

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
                DriverManager.driver.findElement(page.accessibilityElement).isDisplayed(),
                "Home element not visible");

        // 4. ekstra check (source debug için)
        System.out.println(DriverManager.driver.getPageSource());
    }
}