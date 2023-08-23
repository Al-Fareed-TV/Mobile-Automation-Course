package screens;
import io.appium.java_client.AppiumDriver;
import models.User;

public class SignupScreen {

    private AppiumDriver appiumDriver;

    public SignupScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public HomeScreen signup(User client) {
        return new HomeScreen(appiumDriver);
    }
}
