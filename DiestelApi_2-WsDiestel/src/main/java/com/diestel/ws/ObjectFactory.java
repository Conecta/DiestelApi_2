
package test;

import com.diestel.ws.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.diestel.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfCCampo_QNAME = new QName("http://www.pagoexpress.com.mx/pxUniversal", "ArrayOfCCampo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.diestel.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ejecuta }
     * 
     */
    public Ejecuta createEjecuta() {
        return new Ejecuta();
    }

    /**
     * Create an instance of {@link ArrayOfCCampo }
     * 
     */
    public ArrayOfCCampo createArrayOfCCampo() {
        return new ArrayOfCCampo();
    }

    /**
     * Create an instance of {@link Test }
     * 
     */
    public Test createTest() {
        return new Test();
    }

    /**
     * Create an instance of {@link TestResponse }
     * 
     */
    public TestResponse createTestResponse() {
        return new TestResponse();
    }

    /**
     * Create an instance of {@link InfoResponse }
     * 
     */
    public InfoResponse createInfoResponse() {
        return new InfoResponse();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link ReversaResponse }
     * 
     */
    public ReversaResponse createReversaResponse() {
        return new ReversaResponse();
    }

    /**
     * Create an instance of {@link Reversa }
     * 
     */
    public Reversa createReversa() {
        return new Reversa();
    }

    /**
     * Create an instance of {@link EjecutaResponse }
     * 
     */
    public EjecutaResponse createEjecutaResponse() {
        return new EjecutaResponse();
    }

    /**
     * Create an instance of {@link CCampo }
     * 
     */
    public CCampo createCCampo() {
        return new CCampo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCCampo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pagoexpress.com.mx/pxUniversal", name = "ArrayOfCCampo")
    public JAXBElement<ArrayOfCCampo> createArrayOfCCampo(ArrayOfCCampo value) {
        return new JAXBElement<ArrayOfCCampo>(_ArrayOfCCampo_QNAME, ArrayOfCCampo.class, null, value);
    }

}
