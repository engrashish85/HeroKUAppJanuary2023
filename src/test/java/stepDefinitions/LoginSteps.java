package stepDefinitions;

import browser.util.ApplicationUrlBuilder;
import browser.util.Browser;
import cucumber.api.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reporter.ExtentReporter;

import java.io.IOException;


public class LoginSteps {

    Logger logger = Logger.getLogger(LoginSteps.class);
    public ApplicationUrlBuilder appUrls;

    @Given("the user is on login page")
    public void theUserIsOnLoginPage() {
        logger.info("the user is on login page");
    }

    @And("Enters the login credentials")
    public void entersTheLoginCredentials() {
        logger.info("Enters the login credentials");
    }

    @And("Enters the login credentials as {string} and {string}")
    public void entersTheLoginCredentialsAsAnd(String userId, String password) {
        logger.info("The user id entered is - "+userId + " and password entered is - "+password);
    }


    @Given("I login into {string} application")
    public void iLoginIntoApplication(String applicationName) {
        String url = null;
        appUrls = new ApplicationUrlBuilder();
        switch (applicationName.toUpperCase()) {
            case "APPLICATIONA":
                url = appUrls.resolvedUrl("applicationA");
                Browser.getInstance().getCurrentDriver().get(url);
                break;
            default:
                logger.info("The application name given is not valid");
        }
    }

    @Given("I invoke chrome browser using webDriverManager")
    public void iInvokeChromeBrowserUsingWebDriverManager() {
        Browser.invokeBrowser("https://the-internet.herokuapp.com/");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        System.out.println("entered tear down");
        scenario.attach(new ExtentReporter().takeByteScreenshot(), "image/png", scenario.getName());
        Browser.getInstance().getCurrentDriver().quit();
    }

    @And("click on the {string} link")
    public void clickOnTheLink(String stringName) {
        WebDriver driver = Browser.getInstance().getCurrentDriver();
        driver.findElement(By.linkText(stringName)).click();
    }

}
