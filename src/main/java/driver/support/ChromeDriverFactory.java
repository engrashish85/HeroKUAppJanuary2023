package driver.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class ChromeDriverFactory implements AbstractDriverFactory {
    public WebDriver getDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("applicationCacheEnabled", false);
        // DesiredCapabilities d = Desired Capabilities.chrome();
        LoggingPreferences LogPrefs= new LoggingPreferences();
        LogPrefs.enable (LogType.PERFORMANCE, Level.ALL);
        return new Chrome().getWebDriverObject (desiredCapabilities);
    }
}
