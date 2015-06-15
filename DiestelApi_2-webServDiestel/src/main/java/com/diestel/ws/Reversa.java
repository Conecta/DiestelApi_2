
package com.diestel.ws;

import com.diestel.ws.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="cArrayCampos" type="{http://www.pagoexpress.com.mx/pxUniversal}ArrayOfCCampo" minOccurs="0"/>
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
    "cArrayCampos"
})
@XmlRootElement(name = "Reversa")
public class Reversa {

    protected ArrayOfCCampo cArrayCampos;

    /**
     * Gets the value of the cArrayCampos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCCampo }
     *     
     */
    public ArrayOfCCampo getCArrayCampos() {
        return cArrayCampos;
    }

    /**
     * Sets the value of the cArrayCampos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCCampo }
     *     
     */
    public void setCArrayCampos(ArrayOfCCampo value) {
        this.cArrayCampos = value;
    }

}
