package drivers;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverManager<Driver> {

    // A new driver comes to life
    Driver create(DesiredCapabilities desiredCapabilities);
}