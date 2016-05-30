package custom_elements.selophane.widget;

import custom_elements.selophane.base.ElementImpl;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Wraps a label on a html form with some behavior.
 */
public class LabelImpl extends ElementImpl implements Label {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public LabelImpl(WebElement element) {
        super(element);
    }

    @Override
    public String getFor() {
        return getWrappedElement().getAttribute("for");
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
