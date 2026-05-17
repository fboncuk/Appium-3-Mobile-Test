package tests;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.NoSuchElementException;

public class C04_ToastMessageTest extends BaseTest {

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    AccessibilityPage accessibilityPage = new AccessibilityPage();
    AnimationPage animationPage = new AnimationPage();
    ContentPage contentPage = new ContentPage();
    ViewsPage viewsPage = new ViewsPage();
    AppPage appPage = new AppPage();

    @Test
    public void toastNotification (){

        // Ana sayfadan alt sayfalara doğru 3 tıklama ile girilir
        driver.findElement(apiDemosPage.appElement).click();
        driver.findElement(appPage.NotificationElement).click();
        driver.findElement(appPage.NotifyWithTextElement).click();

        // Ekranda çıkacak "Short Notification" tetiklenir
        driver.findElement(appPage.ShowShortNotificationElement).click();

        String expectedText = "Short notification";

        // "FluentWait" kodu, Selenium kütüphanesine ait esnek bir bekleme sınıfıdır
        // Short notification kısa süreli gözükeceği için
        // dinamik bir wait nesnesi oluşturulur
        // "wait" değişkeni anlamı: AndroidDriver için bir wait mekanizması oluşturuyorum
        Wait<AndroidDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5)) // azami bekleme
                .pollingEvery(Duration.ofMillis(200)) // 200ms'de bir kontrol yapılır
                .ignoring(NoSuchElementException.class); // “Element yoksa tekrar dene”

        // wait şunu yapar:
        // 5 saniye boyunca her 200 ms’de bir element var mı diye bakar
        // yoksa hata vermeden tekrar dener, bulursa hemen devam eder


        // actualToast kısa süreli görünecek notificationa verdiğimiz isim
        // d = driver, lambda expression (kısa fonksiyon)
        // Anlamı: “Her denemede driver’ı bana ver
        // "//android.widget.Toast" xpath olarak standart Toast (notification) locator yapısı
        WebElement actualToast = wait.until(d ->
                d.findElement(By.xpath("//android.widget.Toast"))
        );
        // Eski yöntemle lambda expression olmadan yazımı
        // public WebElement apply(AndroidDriver d) {
        // return d.findElement(By.xpath("//android.widget.Toast"));}


        String actualText = actualToast.getText();
        Assert.assertEquals(actualText,expectedText);

        // İstenirse notification text yazdırılır
        System.out.println(actualToast.getText());

    }

}
