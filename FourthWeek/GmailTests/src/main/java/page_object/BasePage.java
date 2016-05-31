package page_object;

import com.google.common.base.Predicate;
import custom_element.selophane.custom.CustomElementLocatorFactory;
import custom_element.selophane.factory.api.ElementFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by yashaka on 7/18/15.
 */
abstract public class BasePage {

    protected WebDriver driver;
    protected FluentWait wait;

    public BasePage(WebDriver driver){
        ElementFactory.initElements(new CustomElementLocatorFactory(driver, Configuration.TIMEOUT), this);
        this.driver = driver;
        wait = new FluentWait(driver)
                .withTimeout(Configuration.TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(300, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    protected void alertHandling() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Configuration.ALERT_TIMEOUT);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //something
        }
    }

    protected void waitForJs() {
        wait.until((Predicate<WebDriver>) driver1 -> {
                    return ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
                }
        );
    }

}
