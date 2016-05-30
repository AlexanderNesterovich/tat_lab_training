package page_objects;

import com.google.common.base.Predicate;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver_stuff.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by yashaka on 7/18/15.
 */
abstract public class BasePage {

    static public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Configuration.TIMEOUT);
        wait.withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    protected void alertHandling() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            return;
        }
    }

    protected void waitForJs() {
        wait.until((Predicate<WebDriver>) driver1 -> {
                    return ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
                }
        );
    }

    protected WebDriver driver;


}
