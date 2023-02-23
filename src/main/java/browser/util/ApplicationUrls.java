package browser.util;

import files.util.Globals;
import files.util.PropertyFileReader;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;
public class ApplicationUrls {

    private static final Logger logger = Logger.getLogger(ApplicationUrls.class);
    private static Map<String, String> config;
    private static String applicationAUrl = null;

    public ApplicationUrls() {
        try {
            ApplicationUrls.config = PropertyFileReader.readProperties(Globals.CONFIG_LOCATION.toString());
        } catch (IOException e) {
            Assert.fail("Unable to find the correct path for config.properties file with exception as - "+e.getMessage() +
                    e.getCause());
        }
        ApplicationUrls.applicationAUrl = ApplicationUrls.config.get("applicationAUrl");
    }

    public String getApplicationAUrl() {
        return ApplicationUrls.applicationAUrl;
    }

}
