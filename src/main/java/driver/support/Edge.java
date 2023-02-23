package driver.support;

import files.util.Globals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class Edge implements DriverSetup {

    @Override
    public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
        System.setProperty("webdriver.edge.driver", "C:\\ASHISH");
        EdgeOptions options = new EdgeOptions();
        HashMap<String, Object> preferences = new HashMap<> ();
        preferences.put(" profile.password_manager_enabled", false);
        String fileLocationInMachine = Globals.DOWNLOAD_LOCATION.toString();
        fileLocationInMachine = fileLocationInMachine.replace( "/", "\\");
        preferences.put("download.default_directory",fileLocationInMachine);
        capabilities.setCapability( "applicationCacheEnabled", false);
        options.merge(capabilities);
        options.addArguments ("--no-sandbox");
        options.addArguments ("--disable-setuid-sandbox");
        options.addArguments ("--no-default-browser-check");
        options.addArguments ("--disable-extensions");
        options.addArguments("test-type");
        options.addArguments ("--remote-debugging-port=9222");
        options.setExperimentalOption( "prefs", preferences);
        options.addArguments ("--disable-session-crashed-bubble");
        options.addArguments ("--disable-application-cache");
        options.addArguments ("--disable-dev-shm-usage");
        options.addArguments ("--headless");
        return new EdgeDriver(options);
    }

}
