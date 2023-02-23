package driver.support;

import files.util.Globals;
import files.util.PropertyFileReader;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class OtherProperties {

    private static final Logger logger = Logger.getLogger(OtherProperties.class);
    private static Map<String, String> config;
    private static String functionalTest = null;
    private static String cddRegression = null;
    private static String headless = null;
    private static String remoteDriver = null;
    private static String browser = null;
    private static String ieMode = null;
    private static String pvt = null;
    private static String provision = null;
    private static String jenkinsWorkspace = null;
    // not using harnessMode flag yet...but soon will do
    private static String useHarnessMode = null;

    /**
     * constructor for OtherProperties takes file path to connect and read
     */
    public OtherProperties() {
        try {
            OtherProperties.config = PropertyFileReader.readProperties(Globals.CONFIG_LOCATION.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        OtherProperties.functionalTest = OtherProperties.config.get("functional Test");
        OtherProperties.useHarnessMode = OtherProperties.config.get("useHarnessMode");
        OtherProperties.cddRegression = OtherProperties.config.get("cadRegression");
        OtherProperties.remoteDriver = OtherProperties.config.get("remoteDriver");
        OtherProperties.browser = OtherProperties.config.get("browser");
        OtherProperties.headless = OtherProperties.config.get("headless");
        OtherProperties.provision = OtherProperties.config.get("provision");
        OtherProperties.pvt = OtherProperties.config.get("pvt");
        OtherProperties.ieMode = OtherProperties.config.get("leMode");

        if (java.lang.System.getProperty("seleniumGrid") != null && java.lang.System.getProperty("seleniumGrid").
                equalsIgnoreCase("Yes")) {
            OtherProperties.remoteDriver = System.getProperty("seleniumGrid");
        }
        if (java.lang.System.getProperty("BUILD_URL") != null) {
            OtherProperties.jenkinsWorkspace = System.getProperty("BUILD_URL");
        }
    }

    /* Gets flag for functional tests
    +
    * @return true if set else false
    */
    public String getFunctionalTest() {
        return OtherProperties.functionalTest;
    }

    /**
     * Gets flag for harness mode test data
     * +
     *
     * @return true if set else false
     **/
    public String getuseHarnessMode() {
        return OtherProperties.useHarnessMode;
    }

    /*Gets flag for cdd regression tests
     * @return true if set else false*/
    public String getCodRegressionFlag() {
        return OtherProperties.cddRegression;
    }

//    Gets flag for headless browser

    /**
     * Less() { return OtherProperties.headless; }
     * Gets flag for remote driver
     * Breturn true if set else false
     **/
    public String getRemoteDriver() {
        return OtherProperties.remoteDriver;
    }

    /*Gets browser
    name
    return browser
    name*/

    public String getBrowser() {
//Environment.setSessoinVeriable("browser", browser);
        return browser;
    }

    public String getIeMode() {
        return OtherProperties.ieMode;
    }

    public String getPvt() {
        return OtherProperties.pvt;
    }

    public String getProvision() {
        return OtherProperties.provision;
    }

    public String getJenkinsWorkspace() {
        return OtherProperties.jenkinsWorkspace;
    }
}
