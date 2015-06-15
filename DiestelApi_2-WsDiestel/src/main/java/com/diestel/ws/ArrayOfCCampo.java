
package test;

import com.diestel.ws.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCCampo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCCampo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cCampo" type="{http://www.pagoexpress.com.mx/pxUniversal}cCampo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCCampo", propOrder = {
    "cCampo"
})
public class ArrayOfCCampo {

    @XmlElement(nillable = true)
    protected List<CCampo> cCampo;

    /**
     * Gets the value of the cCampo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cCampo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCCampo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CCampo }
     * 
     * 
     */
    public List<CCampo> getCCampo() {
        if (cCampo == null) {
            cCampo = new ArrayList<CCampo>();
        }
        return this.cCampo;
    }

}
