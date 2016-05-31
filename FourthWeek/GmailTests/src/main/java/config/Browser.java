package config;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/31/2016.
 */
public enum Browser {
    CHROME {
        public WebDriver create(){
            System.setProperty("webdriver.chrome.driver", "C:/tmp/chromedriver.exe");
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            WebDriver tmp = new ChromeDriver(dc);
            tmp.manage().window().maximize();
            return tmp;
        }
    },
    FIREFOX {
        public WebDriver create() {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            WebDriver tmp = new FirefoxDriver(dc);
            tmp.manage().window().maximize();
            return tmp;
        }
    };
    public WebDriver create(){
        return null;
    }
}
