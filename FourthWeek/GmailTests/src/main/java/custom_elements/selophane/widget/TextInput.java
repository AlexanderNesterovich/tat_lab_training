package custom_elements.selophane.widget;

import custom_elements.selophane.base.Element;
import custom_elements.selophane.base.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element {
    /**
     * @param text The text to type into the field.
     */
    void set(String text);
}
