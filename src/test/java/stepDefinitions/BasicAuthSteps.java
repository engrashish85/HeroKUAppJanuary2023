package stepDefinitions;

import browser.util.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class BasicAuthSteps {

    @Given("I invoke Basic Auth URL using webDriverManager")
    public void iInvokeBasicAuthURLUsingWebDriverManager() {
        Browser.invokeBrowser("https://admin:admin@the-internet.herokuapp.com/");

    }

    @Then("I implement Basic Auth")
    public void iImplementBasicAuth() {
        WebDriver driver = Browser.getInstance().getCurrentDriver();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Given("I implement Basic Auth using ChromeDevTools")
    public void iImplementBasicAuthUsingChromeDevTools() throws EncoderException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        Map<String, Object> headers = new HashMap<>();
        String basicAuth = "Basic" + new String (String.valueOf(new Base64().encode(String.format("%s:%s", "admin", "admin"))));
        headers.put("Authorization", basicAuth);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }
}
