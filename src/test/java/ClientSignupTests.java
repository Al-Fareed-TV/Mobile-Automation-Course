import io.appium.java_client.AppiumDriver;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LauncherScreen;
import screens.ProfileScreen;
import screens.SignupScreen;

public class ClientSignupTests {

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
}
