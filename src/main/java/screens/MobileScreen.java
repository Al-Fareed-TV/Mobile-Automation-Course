package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public abstract class MobileScreen {
    By createClientAccountBtn = By.xpath("//*[@text='CREATE CLIENT ACCOUNT']");
    By createCoachAccountBtn = By.xpath("//*[@text='CREATE COACH ACCOUNT']");
    By loginBtn = By.xpath("//*[@text='Log In']");

    public MobileScreen() {
        super();
    }

    PageActions actions;
    AppiumDriver appiumDriver;


    public SignupScreen navToClientSignup() {
        actions.click(createClientAccountBtn);
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToCoachSignup() {
        actions.click(createCoachAccountBtn);
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToLogin() {
        actions.click(loginBtn);
        return new SignupScreen(appiumDriver);
    }
}
