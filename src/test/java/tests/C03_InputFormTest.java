package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class C03_InputFormTest extends BaseTest {

    // Bu test ile yapılabilecek doğrulamalar:
    // text input, checkbox, radio button, toggle button girişleri

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    AccessibilityPage accessibilityPage = new AccessibilityPage();
    AnimationPage animationPage = new AnimationPage();
    ContentPage contentPage = new ContentPage();
    ViewPage viewPage = new ViewPage();

    // 1. Test
    @Test
    public void textBoxWriteTest (){
        // Views-Controls-1. Light Theme sayfasında text box'a bir metin girilir
        // yazının kututuda yer aldığı doğrulanır

        // öncelikle 1. Light Theme sayfasına ulaşalım
        driver.findElement(apiDemosPage.viewsElement).click();
        driver.findElement(viewPage.ControlsElement).click();
        driver.findElement(viewPage.LightThemeElement).click();

        String expectedText = "deneme yazisi";
        driver.findElement(viewPage.TextBoxElement).sendKeys(expectedText);

        String actualText = driver.findElement(viewPage.TextBoxElement).getText();

        Assert.assertEquals(actualText,expectedText);

    }




    
}
