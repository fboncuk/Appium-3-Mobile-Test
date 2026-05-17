package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Map;

public class C05_ScrollTest extends BaseTest {

    // Scroll, ekranda aşağı veya yukarı kaydırma işlemidir.
    // Views menüsü içinde scroll testi yapılır

    // Locators sayfaları
    ApiDemosPage apiDemosPage = new ApiDemosPage();
    ViewsPage viewsPage = new ViewsPage();

    @Test
    public void PageScrollTest (){

        // Views sayfasına gidilir
        driver.findElement(apiDemosPage.viewsElement).click();

        // "Web view" menüsü görünene kadar sayfa scroll edilir
        // sayfadaki scroll edilebilecek alan seçilir
        String scrollablePart = "new UiScrollable(new UiSelector().scrollable(true))";

        // sayfada hangi elemente kadar scroll edilmesi gerekli belirtilir
        String actionPart = ".scrollIntoView(text(\"WebView\"))";

        // Yukarıdaki iki komut string olarak birleştirilerek Android'e gönderilir
        // Java içinde parçalı olsa da komut Appium’a her zaman tek bir stringle gönderilir,
        // çünkü UiAutomator komutu cihaz tarafında string olarak execute edilir.
        String command = scrollablePart + actionPart;

        driver.findElement(AppiumBy.androidUIAutomator(command));

        // yukarıdaki kodların tek komutla yazılmış hali:
        // driver.findElement(AppiumBy.androidUIAutomator(
        //        "new UiScrollable(new UiSelector().scrollable(true))" +
        //                ".scrollIntoView(text(\"WebView\"))"
        // ));

        // WebView görünüyor mu kontrol edilir
        String expectedText = "WebView";
        String actualText = driver.findElement(viewsPage.WebViewElement).getText();

        Assert.assertEquals(actualText,expectedText);

    }



}
