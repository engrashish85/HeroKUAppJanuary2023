package reporter;

import browser.util.Browser;
import files.util.Globals;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReporter {
    public byte[] takeByteScreenshot() throws IOException {
        TakesScreenshot takesScreenshot = ((TakesScreenshot)Browser.getInstance().getCurrentDriver());
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }

}
