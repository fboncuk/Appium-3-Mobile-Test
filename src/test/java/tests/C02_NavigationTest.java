package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccessibilityPage;
import pages.AnimationPage;
import pages.ApiDemosPage;
import pages.ContentPage;

public class C02_NavigationTest extends BaseTest {

    // Navigasyon testleri en temel test yöntemlerindendir
    // ApiDemos-debug_v6.0.10.apk uygulaması telefona kurulmuş olmalıdır

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    AccessibilityPage accessibilityPage = new AccessibilityPage();
    AnimationPage animationPage = new AnimationPage();
    ContentPage contentPage = new ContentPage();

    // 1. test
    @Test
    public void navigateAnimationMenu (){
        // Kullanıcı Animation menüsüne tıklar
        // Sayfanın açıldığını görür
        // Geri döner

        driver.findElement(apiDemosPage.animationElement).click();

        // Animation sayfasındaki BouncingBalls menü ismi bir değişkene atanır
        // Sayfanın açık olduğu bu sayede doğrulanır
        String expectedName = "Bouncing Balls";
        String actualName = driver.findElement(animationPage.BouncingBallsElement).getText();

        Assert.assertEquals(actualName,expectedName);
        driver.navigate().back();

    }


    // 2. test
    @Test
    public void navigateContentMenu (){
        // Content menüsüne tıklar
        // Sayfanın açıldığını görür
        // Provider menüsüne tıklar
        // Sayfanın açıldığını görür
        // Ana syfaya döner (2 geri tıklama)

        driver.findElement(apiDemosPage.contentElement).click();
        Assert.assertTrue(driver.findElement(contentPage.ProviderElement).isDisplayed());

        driver.findElement(contentPage.ProviderElement).click();
        // Burada hem Pick Contact locator'ı oluşturup hem de görünürlük testini yapacağız
        Assert.assertTrue(driver
                .findElement(AppiumBy.accessibilityId("Pick Contact")).isDisplayed()
        );
        driver.navigate().back();
        driver.navigate().back();

    }



}
