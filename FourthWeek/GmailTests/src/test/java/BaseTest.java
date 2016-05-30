import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/25/2016.
 */
abstract public class BaseTest {

    protected static final WebDriver driver;

    static{
        System.setProperty("webdriver.chrome.driver", "C:/tmp/chromedriver.exe");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        driver = new ChromeDriver(dc);
/*        driver.manage().timeouts().implicitlyWait(Configuration.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Configuration.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Configuration.TIMEOUT, TimeUnit.SECONDS);*/
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void TearDown(ITestResult result) throws IOException
    {
        //If the Testcase fail then only it enters to if condition block

        //.getStatus will return Test "Pass" or "Fail"

        System.out.println("Testcase status is"+result.getStatus());
        System.out.println("Iresult status is"+result.FAILURE);

        if(result.FAILURE == result.getStatus())
        {
            //Now we need to capture Screenshot
            //use CaptureScreenshot Class to Take Screenshot

            CaptureScreenShot.takescreenshot(driver, "Titlefailed");

        }
        driver.quit();
    }
}
