package screens;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected PageActions actions;

    public BasePage(WebDriver webDriver) {
        this.actions = new PageActions(webDriver);
    }
}
