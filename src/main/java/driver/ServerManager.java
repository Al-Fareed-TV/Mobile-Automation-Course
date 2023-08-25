package driver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import static org.awaitility.Awaitility.await;
import java.time.Duration;
import java.net.URL;

public class ServerManager {
    private AppiumDriverLocalService service;

    public ServerManager() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder().usingAnyFreePort();
        service = AppiumDriverLocalService.buildService(builder);
    }

    public URL start() {
        service.start();
        await().atMost(Duration.ofSeconds(10)).until(service::isRunning);
        return service.getUrl();
    }

    public void stop() {
        service.stop();
    }
}