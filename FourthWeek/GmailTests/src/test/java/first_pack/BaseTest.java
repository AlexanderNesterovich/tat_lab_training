package first_pack;

import util.browser_instantiator.Browser;
import util.logging.CaptureScreenShot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import util.logging.TracingWebDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/25/2016.
 */
@Listeners({BaseTest.LogListener.class})
abstract public class BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    protected void setUp() {
        driver = new TracingWebDriver(Browser.CHROME.create());
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

    public static class LogListener implements IInvokedMethodListener {

        @Override
        public void afterInvocation(IInvokedMethod m, ITestResult res) {
            LOG.info("<<< @Test " + m);
        }

        @Override
        public void beforeInvocation(IInvokedMethod m, ITestResult res) {
            LOG.info(">>> @Test " + m);
        }

    }

}
