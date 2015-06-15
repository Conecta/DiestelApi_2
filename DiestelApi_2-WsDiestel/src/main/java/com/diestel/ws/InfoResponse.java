
package test;

import com.diestel.ws.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InfoResult" type="{http://www.pagoexpress.com.mx/pxUniversal}ArrayOfCCampo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infoResult"
})
@XmlRootElement(name = "InfoResponse")
public class InfoResponse {

    @XmlElement(name = "InfoResult")
    protected ArrayOfCCampo infoResult;

    /**
     * Gets the value of the infoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCCampo }
     *     
     */
    public ArrayOfCCampo getInfoResult() {
        return infoResult;
    }

    /**
     * Sets the value of the infoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCCampo }
     *     
     */
    public void setInfoResult(ArrayOfCCampo value) {
        this.infoResult = value;
    }

}
