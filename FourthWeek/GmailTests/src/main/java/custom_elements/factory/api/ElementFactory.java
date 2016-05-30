package custom_elements.factory.api;

import custom_elements.factory.internal.ElementDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import webdriver_stuff.Configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Element factory for wrapped elements. Similar to {@link org.openqa.selenium.support.PageFactory}
 */
public class ElementFactory {

    /**
     *  See {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.WebDriver driver, Class)}
     */
    public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
        T page = instantiatePage(driver, pageClassToProxy);
        return initElements(driver, page);
    }

    /**
     * As
     * {@link ElementFactory#initElements(org.openqa.selenium.WebDriver, Class)}
     * but will only replace the fields of an already instantiated Page Object.
     * 
     * @param searchContext A search context that will be used to look up the elements
     * @param page The object with WebElement and List<WebElement> fields that should be proxied.
     * @return the initialized page-object.
     */
    public static <T> T initElements(SearchContext searchContext, T page) {
        initElements(new ElementDecorator(new AjaxElementLocatorFactory(searchContext, Configuration.TIMEOUT)), page);
        return page;
    }

    /**
     * see {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.support.pagefactory.ElementLocatorFactory, Object)}
     */
    public static void initElements(AjaxElementLocatorFactory factory, Object page) {
        final AjaxElementLocatorFactory factoryRef = factory;
        initElements(new ElementDecorator(factoryRef), page);
    }

    /**
     * see {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.support.pagefactory.ElementLocatorFactory, Object)}
     */
    public static void initElements(FieldDecorator decorator, Object page) {
        PageFactory.initElements(decorator, page);
    }

    /**
     * Copy of {@link org.openqa.selenium.support.PageFactory#instantiatePage(org.openqa.selenium.WebDriver, Class)}
     */
    private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException e) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
