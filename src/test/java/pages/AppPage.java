package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AppPage {

    // App Locators
    public By NotificationElement = AppiumBy.accessibilityId("Notification");

    // App-Notification Locators
    public By NotifyWithTextElement = AppiumBy.accessibilityId("NotifyWithText");

    // App-Notification-NotifyWithText Locators
    public By ShowShortNotificationElement = AppiumBy.accessibilityId("Show Short Notification");
    public By ShowLongNotificationElement = AppiumBy.accessibilityId("Show Long Notification");


}
