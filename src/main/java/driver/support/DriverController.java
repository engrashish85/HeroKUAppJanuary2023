package driver.support;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverController {
    private static final Logger logger = Logger.getLogger (DriverController.class);
    public static WebDriver selectWebDriver (String selectDriver) {
//    Environment.setSessoinVeriable("browser", selectDriver);

        if (selectDriver.equalsIgnoreCase (DriverType.CHROME.getName())) {
            return DriverType.CHROME.getDriver();
        //} else if (selectDriver.equalsIgnoreCase (DriverType.IE.getName())) {
            //return DriverType.IE.getDriver();
        //} else if (selectDriver.equalsIgnoreCase (DriverType.FIREFOX.getName())) {
            //return DriverType.FIREFOX.getDriver();
        //} else if (selectDriver.equalsIgnoreCase (DriverType.ANDROID.getName())) {
           // return DriverType.ANDROID.getDriver();
        } else if (selectDriver.equalsIgnoreCase (DriverType.EDGE.getName())) {
            return DriverType.EDGE.getDriver();
        } else {
            DriverController.logger.info("Unknown Driver Type [" + selectDriver + "]");
        }
        return null;
    }
    public static void closeDriver() {
        if (DriverInstance.remoteWebDriver != null) {
            DriverInstance.remoteWebDriver.close();
            DriverInstance.remoteWebDriver.quit();
            DriverInstance.remoteWebDriver = null;
        }
    }
}
