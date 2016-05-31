package custom_element.selophane.custom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;

import java.lang.reflect.Field;

/**
 * Created by Alexander Nesterovich on 31.05.2016.
 */
public class CustomElementLocator extends AjaxElementLocator {
    public CustomElementLocator(WebDriver driver, Field field,
                                int timeOutInSeconds) {
        super(driver, field, timeOutInSeconds);
    }

    protected boolean isElementUsable(WebElement element) {
        return element.isDisplayed();
    }
}
