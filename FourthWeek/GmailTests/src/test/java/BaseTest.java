import config.Browser;
import config.CaptureScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/25/2016.
 */
abstract public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    protected void setUp() {
        driver = Browser.CHROME.create();
    }

    @AfterMethod
    protected void screenShotTearDown(ITestResult result) throws IOException {
        if(result.FAILURE == result.getStatus()) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH-mm");
            Date resultdate = new Date(result.getStartMillis());
            CaptureScreenShot.takescreenshot(driver, result.getInstanceName() + " - " + result.getMethod().getMethodName() + " - " + sdf.format(resultdate));
        }
    }

    @BeforeMethod
    protected void cleanCookiesSetUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }

}
