import driver.ServerManager;
import io.appium.java_client.AppiumDriver;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LauncherScreen;
import screens.ProfileScreen;
import screens.SignupScreen;

import java.net.URL;

public class ClientSignupTests {
    private ServerManager serverManager;

    @BeforeClass
    public void setup() {
        serverManager = new ServerManager();
        URL appiumServerUrl = serverManager.start();
        System.out.println("Appium server started at URL: " + appiumServerUrl);
    }
    @Test
    public void clientShouldBeAbleToSignupSuccessfully() {
        //Arrange


        AppiumDriver mobileDriver = null;
        LauncherScreen launcherScreen = new LauncherScreen(mobileDriver); // Assume mobileDriver is created and handy.
        launcherScreen.navToClientSignup();
        User client = new User("randomclient@gmail.com",
                "password",
                "Automation Client",
                "1234567890");

        //Act
        SignupScreen signupScreen = new SignupScreen(mobileDriver);
        HomeScreen homeScreen = signupScreen.signup(client);

        ProfileScreen profileScreen = homeScreen.navToProfile();
        User clientProfile =  profileScreen.getProfileDetails();

        // Assert
        Assert.assertEquals(clientProfile.getEmail(), client.getEmail());
        Assert.assertEquals(clientProfile.getFullName(), client.getFullName());
        Assert.assertEquals(clientProfile.getMobile(), client.getMobile());

        // Assume we have called a date utility to supply Today's Date
        Assert.assertEquals(clientProfile.getMembershipStartDate(), "Today's Date");

    }

    @AfterClass
    public void teardown() {
        serverManager.stop();
        System.out.println("Appium server stopped.");
    }
}
