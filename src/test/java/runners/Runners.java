package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepDefinitions"},
        tags = "@run"

)
public class Runners extends AbstractTestNGCucumberTests {

}
