/**
 * Created by Alexander Nesterovich on 20.05.2016.
 */

@XmlSchema(
        namespace = "http://www.training.by/Library",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="lib", namespaceURI="http://www.training.by/Library")
        }
)

package by.training.bean;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;





