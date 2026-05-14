package tests;

import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class C01_InstallTest extends BaseTest {

    @Test
    public void verifyAppInstallAndLaunch() {

        String appPackage = ConfigReader.get("appPackage");

        // 1. App installed mi?
        boolean isInstalled =
                DriverManager.driver.isAppInstalled(appPackage);

        Assert.assertTrue(isInstalled, "App is NOT installed");

        // 2. App açık mı? (simple check)
        String currentPackage =
                DriverManager.driver.getCurrentPackage();

        Assert.assertEquals(currentPackage, appPackage);
    }
}