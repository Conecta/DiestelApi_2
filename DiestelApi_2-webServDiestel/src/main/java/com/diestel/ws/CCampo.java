
package com.diestel.ws;

import com.diestel.ws.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cCampo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cCampo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sCampo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iTipo" type="{http://www.pagoexpress.com.mx/pxUniversal}eTipo"/>
 *         &lt;element name="iLongitud" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iClase" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sValor" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="bEncriptado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cCampo", propOrder = {
    "sCampo",
    "iTipo",
    "iLongitud",
    "iClase",
    "sValor",
    "bEncriptado"
})
public class CCampo {

    protected String sCampo;
    @XmlElement(required = true)
    protected ETipo iTipo;
    protected int iLongitud;
    protected int iClase;
    protected Object sValor;
    protected boolean bEncriptado;

    /**
     * Gets the value of the sCampo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCampo() {
        return sCampo;
    }

    /**
     * Sets the value of the sCampo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCampo(String value) {
        this.sCampo = value;
    }

    /**
     * Gets the value of the iTipo property.
     * 
     * @return
     *     possible object is
     *     {@link ETipo }
     *     
     */
    public ETipo getITipo() {
        return iTipo;
    }

    /**
     * Sets the value of the iTipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ETipo }
     *     
     */
    public void setITipo(ETipo value) {
        this.iTipo = value;
    }

    /**
     * Gets the value of the iLongitud property.
     * 
     */
    public int getILongitud() {
        return iLongitud;
    }

    /**
     * Sets the value of the iLongitud property.
     * 
     */
    public void setILongitud(int value) {
        this.iLongitud = value;
    }

    /**
     * Gets the value of the iClase property.
     * 
     */
    public int getIClase() {
        return iClase;
    }

    /**
     * Sets the value of the iClase property.
     * 
     */
    public void setIClase(int value) {
        this.iClase = value;
    }

    /**
     * Gets the value of the sValor property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSValor() {
        return sValor;
    }

    /**
     * Sets the value of the sValor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSValor(Object value) {
        this.sValor = value;
    }

    /**
     * Gets the value of the bEncriptado property.
     * 
     */
    public boolean isBEncriptado() {
        return bEncriptado;
    }

    /**
     * Sets the value of the bEncriptado property.
     * 
     */
    public void setBEncriptado(boolean value) {
        this.bEncriptado = value;
    }

}
