package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ApiDemosPage {

    // API Demos ana sayfası
    public By accessibilityElement = AppiumBy.accessibilityId("Accessibility");
    public By animationElement = AppiumBy.accessibilityId("Animation");
    public By appElement = AppiumBy.accessibilityId("App");
    public By contentElement = AppiumBy.accessibilityId("Content");
    public By graphicsElement = AppiumBy.accessibilityId("Graphics");
    public By mediaElement = AppiumBy.accessibilityId("Media");
    public By nfclement = AppiumBy.accessibilityId("NFC");
    public By osElement = AppiumBy.accessibilityId("OS");
    public By preferenceElement = AppiumBy.accessibilityId("Preference");
    public By textElement = AppiumBy.accessibilityId("Text");
    public By viewsElement = AppiumBy.accessibilityId("Views");

    // Accessibility sayfası
    public By ANodeProviderElement = AppiumBy.accessibilityId("Accessibility Node Provider");
    public By ANodeQueryingElement = AppiumBy.accessibilityId("Accessibility Node Querying");
    public By AServiceElement = AppiumBy.accessibilityId("Accessibility Service");
    public By CustomViewElement = AppiumBy.accessibilityId("Custom View");

    // Accessibility Node Provider sayfası
    // accessibilityId kullanarak
    public By ANodeProviderTextElement1 = AppiumBy.
            accessibilityId("Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.");
    // contains xpath kullanarak
    public By ANodeProviderTextElement2 = AppiumBy.
            xpath("//android.widget.TextView[contains(@text,'Enable TalkBack')]");



    // Ornek Locatorlar
    // 1. ÖNCELİK: AccessibilityId en iyisi
    public By ornek_accessibilityId = AppiumBy.accessibilityId("Enable TalkBack");

    //  2. ÖNCELİK: Xpath (text ile)
    public By ornek_xpath = AppiumBy.xpath("//android.widget.TextView[@text='Enable TalkBack']");

    //  3. ÖNCELİK: Contains XPath (daha iyi)
    public By ornek_contains = AppiumBy.xpath("//android.widget.TextView[contains(@text,'TalkBack')]");



}