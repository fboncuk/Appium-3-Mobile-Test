package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AccessibilityPage {

    // Accessibility Page locators
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


}
