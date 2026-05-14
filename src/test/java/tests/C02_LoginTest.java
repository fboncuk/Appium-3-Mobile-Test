package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApiDemosPage;
import driver.DriverManager;

public class C02_LoginTest {

    @Test
    public void guestButtonTest() {

        ApiDemosPage page = new ApiDemosPage();

        boolean isDisplayed =
                DriverManager.driver.findElement(page.continueAsGuestButton)
                        .isDisplayed();

        Assert.assertTrue(isDisplayed);
    }
}