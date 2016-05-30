package custom_elements.selophane.widget;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import custom_elements.selophane.base.ElementImpl;

/**
 * TextInput  wrapper.
 */
public class TextInputImpl extends ElementImpl implements TextInput {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public TextInputImpl(WebElement element) {
        super(element);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }

    @Override
    public void set(String text) {
        WebElement element = getWrappedElement();
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets the value of an input field.
     * @return String with the value of the field.
     */
    @Override
    public String getText() {
        return getWrappedElement().getAttribute("value");
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
