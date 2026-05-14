package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class LoginPage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");

    public void login(String user, String pass) {

        WaitUtils.waitForElement(username);

        DriverManager.driver.findElement(username).sendKeys(user);
        DriverManager.driver.findElement(password).sendKeys(pass);
        DriverManager.driver.findElement(loginBtn).click();
    }
}