package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ViewPage {

    // Views locators
    public By ControlsElement = AppiumBy.accessibilityId("Controls");
    public By LightThemeElement = AppiumBy.accessibilityId("1. Light Theme");

    // Views-Controls-1. Light Theme locators
    public By SaveElement = AppiumBy.id("io.appium.android.apis:id/button");
    public By TextBoxElement = AppiumBy.id("io.appium.android.apis:id/edit");
    public By CheckBox1Element = AppiumBy.accessibilityId("Checkbox 1");
    public By CheckBox2Element = AppiumBy.accessibilityId("Checkbox 2");
    public By RadioButton1Element = AppiumBy.accessibilityId("RadioButton 1");
    public By RadioButton2Element = AppiumBy.accessibilityId("RadioButton 2");
    public By StarElement = AppiumBy.accessibilityId("Star");
    public By OnOff1Element = AppiumBy.id("io.appium.android.apis:id/toggle1");
    public By OnOff2Element = AppiumBy.id("io.appium.android.apis:id/toggle2");
    public By DropDownElement = AppiumBy.id("io.appium.android.apis:id/spinner1");
    public By PlanetsRadioElement = AppiumBy.androidUIAutomator("new UiSelector().text(\"Venus\")");

}
