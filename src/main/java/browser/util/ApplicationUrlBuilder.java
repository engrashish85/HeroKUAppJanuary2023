package browser.util;

import applications.ApplicationA;
import utility.StringHelper;

public class ApplicationUrlBuilder {

    private String getSysPropertyUrl (String sysProperty) {
        String result = null;
        String tmp = System.getProperty(sysProperty);
        if (!StringHelper.isBlankOrEmpty(tmp)) {
            switch (sysProperty.toUpperCase()) {
                case "APPLICATIONA":
                    result = ApplicationA.valueOf(tmp).getUrl();
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private String getConfigUrl(String property) {
        ApplicationUrls applicationUrls = new ApplicationUrls();
        String result = null;
        switch (property.toUpperCase()) {
            case "APPLICATIONA":
                result = applicationUrls.getApplicationAUrl();
        }
        return result;
    }

    public String resolvedUrl(String type) {
        String sysProperty = getSysPropertyUrl(type);
        if (StringHelper.isBlankOrEmpty(sysProperty)) {
            return getConfigUrl(type);
        }
        return sysProperty;
    }
}
