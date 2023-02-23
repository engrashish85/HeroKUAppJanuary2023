package driver.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeDriverFactory implements AbstractDriverFactory {
    @Override
    public WebDriver getDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        return new Edge().getWebDriverObject(desiredCapabilities);
    }
}
