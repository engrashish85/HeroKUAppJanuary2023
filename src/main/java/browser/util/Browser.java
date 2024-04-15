package browser.util;

import driver.support.DriverController;
import driver.support.OtherProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;

public class Browser {
    public static Browser browser = null;
    private static WebDriver webDriver = null;

    private Browser() {
        if (webDriver==null) {
            webDriver = DriverController.selectWebDriver(new OtherProperties().getBrowser());
        }
    }

    private Browser(String browserName) {
        webDriver = DriverController.selectWebDriver(browserName);
    }

    public static Browser getInstance(String... browserName) {
        if (browser == null) {
            if (browserName.length == 0)
                browser = new Browser();
            else
                browser = new Browser(browserName[0]);
        }
        return browser;
    }

    public WebDriver getCurrentDriver() {
        return webDriver;
    }

    public WebDriver setCurrentDriver(WebDriver driver, String browserName) {
        webDriver = driver;
        return webDriver;
    }

    public static void closeCurrentDriver(WebDriver webDriver) {
        if (browser != null) {
            webDriver.close();
            webDriver.quit();
            browser = null;
        }
    }

    public static void setBrowser(Browser value) {
        browser = value;
    }

    public static void invokeBrowser(String url) {
        EdgeOptions edgeOptions = new EdgeOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        edgeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.edgedriver().setup();
//        webDriver = new EdgeDriver();
        webDriver = new EdgeDriver(edgeOptions);
        webDriver.get(url);
    }

    @AfterClass
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
    }


}