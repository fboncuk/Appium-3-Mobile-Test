package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccessibilityPage;
import pages.AnimationPage;
import pages.ApiDemosPage;

public class C02_NavigationTest extends BaseTest {

    // Navigasyon testleri en temel test yöntemlerindendir
    // ApiDemos-debug_v6.0.10.apk uygulaması telefona kurulmuş olmalıdır


    ApiDemosPage apiDemosPage = new ApiDemosPage();
    AccessibilityPage accessibilityPage = new AccessibilityPage();
    AnimationPage animationPage = new AnimationPage();

    // 1. test
    @Test
    public void navigateAccessibility (){
        // Animation menüsüne tıklar
        // Sayfanın açıldığını görür
        // Geri döner
        driver.findElement(apiDemosPage.animationElement).click();

        // Animation sayfasındaki BouncingBalls menü ismi bir değişkene atanır
        // Sayfanın açık olduğu bu sayede doğrulanır
        String expectedName = "Bouncing Bulls";
        String actualName = driver.findElement(animationPage.BouncingBalls).getText();

        Assert.assertEquals(actualName,expectedName);

    }


    // 2. test
    // Content menüsüne tıklar
    // Sayfanın açıldığını görür
    // Content menüsüne tıklar
    // Sayfanın açıldığını görür
    // Ana syfaya döner (2 geri tıklama)
    //
    // 3. test
    // Views menüsüne tıklar
    // Sayfanın açıldığını görür
    // Geri döner



}
