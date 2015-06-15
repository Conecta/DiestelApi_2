
package test;

import com.diestel.ws.*;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eTipo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eTipo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AN"/>
 *     &lt;enumeration value="NE"/>
 *     &lt;enumeration value="NM"/>
 *     &lt;enumeration value="FD"/>
 *     &lt;enumeration value="HR"/>
 *     &lt;enumeration value="ND"/>
 *     &lt;enumeration value="PW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eTipo")
@XmlEnum
public enum ETipo {

    AN,
    NE,
    NM,
    FD,
    HR,
    ND,
    PW;

    public String value() {
        return name();
    }

    public static ETipo fromValue(String v) {
        return valueOf(v);
    }

}
