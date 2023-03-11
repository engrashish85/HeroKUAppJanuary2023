package webElement;

import driver.support.DriverInstance;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends DriverInstance {
    public static <T extends BasePage> T initPage(Class <T> pageClass) {
        return PageFactory.initElements(remoteWebDriver, pageClass);
    }
}
