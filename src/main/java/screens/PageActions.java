package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {
    private WebDriver webDriver;
    private WebDriverWait wait;



    public PageActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);

    }

    public void click(By by) {
        webDriver.findElement(by).click();
    }

    public void type(By by, String value) {
        webDriver.findElement(by).sendKeys(value);
    }

    public void safeClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        webDriver.findElement(by).click();
    }
}

