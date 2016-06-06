package util.logging; /**
 * Created by Aliaksandr_Nestsiarovich on 5/30/2016.
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShot extends TestListenerAdapter {

    public static void takescreenshot(WebDriver driver, String Screenshotname) throws IOException
    {
        TakesScreenshot takescreenshot=(TakesScreenshot)driver;
        File source=takescreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/"+Screenshotname+".png"));
        System.out.println("Screenshot Taken Successfully!");

    }

}
