package driver.support;

import files.util.Globals;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Chrome implements DriverSetup {
    private static final Logger logger = Logger.getLogger (Chrome.class);
//    OtherProperties otherProperties;
    @Override
    public WebDriver getWebDriverObject (DesiredCapabilities capabilities) {
//        other Properties = new Other Properties();
        WebDriver chrome = null;
        HashMap<String, Object> chromePreferences = new HashMap<>();
        chromePreferences.put("profile.password_manager_enabled", false);
        String fileLocationInMachine = Globals.DOWNLOAD_LOCATION.toString();
        fileLocationInMachine = fileLocationInMachine.replace("/","\\");
        chromePreferences.put("download.default_directory", fileLocationInMachine);
//        enableLoggingPref (capabilities);
        ChromeOptions options = new ChromeOptions();
        options = options.merge (capabilities);
        options.addArguments ("--no-default-browser-check");
        options.addArguments ("--disable-extensions");
        options.addArguments ("test-type");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", chromePreferences);
//        if (! (otherProperties.getRemoteDriver () != null && other properties.getRemoteBriver().equalsignoreCase( another String: "YES"))) {
            logger.info("Machine Type: Local windows");
            WebDriver driver = new ChromeDriver(options);
            driver.get("");
//            System.setProperty("webdriver.chrome.driver", Globals.CHROME_DRIVER_EXE.toString());
//                    chrome = new ChromeDriver(options);
//        } else {
            try {
//                enablePerformanceLogging (options);
//                options.addArguments ("chrome.switches", "--disable-extensions");
//                options.addArguments ("--disable-notifications");
//                options.addArguments("--disable-web-security");
//                options.addArguments ("--allow-running-insecure-content");
//                options.addArguments (-ignore-certificate-errors");
//            }
//        }
        options.addArguments ("-ignore-certificate-errors");
        options.addArguments ("--allow-insecure-localhost");
        options.addArguments ("--no-sandbox");
        /*Does not work on selenium grids for ralf
        options.addArguments ("--headless=true");*/
        options.addArguments("--start-maximized");
        logger.info("http://" + Globals.HOST_IP.toString() + ":" +Globals.HOST_PORT.toString() + "/wd/hub");
        chrome = new RemoteWebDriver(new URL("http://" + Globals.HOST_IP.toString() + "/wd/hub"), options);
    } catch (MalformedURLException e) {
                logger.info(e.getCause() + e.getMessage());
            }
            return chrome;
    }

//    private void enableLoggingPref (DesiredCapabilities capabilities) {
//                LoggingPreferences LogPrefs= new LoggingPreferences();
//                if (Environment.hasSessionKeyAndValue(Constants. ENABLE_LOG_PREF.getValue(), value: "Yes")) {
//                    LogPrefs.enable (LogType.BROWSER, Level. ALL);
//                    capabilities.setCapability (CapabilityType.LOGGING PREFS, LogPrefs);
//                }
//                if (Environment.has SessionKeyAndValue(Constants. SELENIUM_GRID.getValue(), value "Y")){
//                    Logger.info("enableLoggingPref cap");
//                    LogPrefs.enable (LogType.PERFORMANCE, Level.ALL);
//                    capabilities.setCapability( "goog: LoggingPrefs", LogPrefs );
//                    private void enable PerformanceLogging (ChromeOptions options) {
//                        if (Environment.hasSessionKeyAndValue (Constants.SELENIUM_GRID.getValue(), value: "Y")){
//                            logger.info("enablePerformanceLogging");
//Removing to check selenium 4.0.0
//options.setExperimentalOption("w3c", false);
}

