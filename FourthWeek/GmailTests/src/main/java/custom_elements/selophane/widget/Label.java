package custom_elements.selophane.widget;

import custom_elements.selophane.base.Element;
import custom_elements.selophane.base.ImplementedBy;

/**
 * Html form label.
 */
@ImplementedBy(LabelImpl.class)
public interface Label extends Element {
    /**
     * Gets the for attribute on the label.
     *
     * @return string containing value of the for attribute, null if empty.
     */
    String getFor();
}
