
package test;

import com.diestel.ws.*;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PxUniversalHttpPost", targetNamespace = "http://www.pagoexpress.com.mx/pxUniversal")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PxUniversalHttpPost {


    /**
     * Prueba de conexion al Web Service
     * 
     * @return
     *     returns com.diestel.ws.ArrayOfCCampo
     */
    @WebMethod(operationName = "Test")
    @WebResult(name = "ArrayOfCCampo", targetNamespace = "http://www.pagoexpress.com.mx/pxUniversal", partName = "Body")
    public ArrayOfCCampo test();

}
