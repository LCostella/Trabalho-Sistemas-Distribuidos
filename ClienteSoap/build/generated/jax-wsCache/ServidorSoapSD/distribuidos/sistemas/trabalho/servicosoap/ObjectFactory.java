
package distribuidos.sistemas.trabalho.servicosoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the distribuidos.sistemas.trabalho.servicosoap package. 
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

    private final static QName _ExcluirResponse_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "excluirResponse");
    private final static QName _BuscarCep_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "buscarCep");
    private final static QName _BuscarContato_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "buscarContato");
    private final static QName _BuscarCepResponse_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "buscarCepResponse");
    private final static QName _InserirResponse_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "inserirResponse");
    private final static QName _Excluir_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "excluir");
    private final static QName _Inserir_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "inserir");
    private final static QName _BuscarContatoResponse_QNAME = new QName("http://servicoSoap.trabalho.sistemas.distribuidos/", "buscarContatoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: distribuidos.sistemas.trabalho.servicosoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscarContatoResponse }
     * 
     */
    public BuscarContatoResponse createBuscarContatoResponse() {
        return new BuscarContatoResponse();
    }

    /**
     * Create an instance of {@link Inserir }
     * 
     */
    public Inserir createInserir() {
        return new Inserir();
    }

    /**
     * Create an instance of {@link Excluir }
     * 
     */
    public Excluir createExcluir() {
        return new Excluir();
    }

    /**
     * Create an instance of {@link InserirResponse }
     * 
     */
    public InserirResponse createInserirResponse() {
        return new InserirResponse();
    }

    /**
     * Create an instance of {@link BuscarCepResponse }
     * 
     */
    public BuscarCepResponse createBuscarCepResponse() {
        return new BuscarCepResponse();
    }

    /**
     * Create an instance of {@link BuscarContato }
     * 
     */
    public BuscarContato createBuscarContato() {
        return new BuscarContato();
    }

    /**
     * Create an instance of {@link BuscarCep }
     * 
     */
    public BuscarCep createBuscarCep() {
        return new BuscarCep();
    }

    /**
     * Create an instance of {@link ExcluirResponse }
     * 
     */
    public ExcluirResponse createExcluirResponse() {
        return new ExcluirResponse();
    }

    /**
     * Create an instance of {@link Cidade }
     * 
     */
    public Cidade createCidade() {
        return new Cidade();
    }

    /**
     * Create an instance of {@link Cep }
     * 
     */
    public Cep createCep() {
        return new Cep();
    }

    /**
     * Create an instance of {@link Contato }
     * 
     */
    public Contato createContato() {
        return new Contato();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcluirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "excluirResponse")
    public JAXBElement<ExcluirResponse> createExcluirResponse(ExcluirResponse value) {
        return new JAXBElement<ExcluirResponse>(_ExcluirResponse_QNAME, ExcluirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarCep }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "buscarCep")
    public JAXBElement<BuscarCep> createBuscarCep(BuscarCep value) {
        return new JAXBElement<BuscarCep>(_BuscarCep_QNAME, BuscarCep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarContato }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "buscarContato")
    public JAXBElement<BuscarContato> createBuscarContato(BuscarContato value) {
        return new JAXBElement<BuscarContato>(_BuscarContato_QNAME, BuscarContato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarCepResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "buscarCepResponse")
    public JAXBElement<BuscarCepResponse> createBuscarCepResponse(BuscarCepResponse value) {
        return new JAXBElement<BuscarCepResponse>(_BuscarCepResponse_QNAME, BuscarCepResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InserirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "inserirResponse")
    public JAXBElement<InserirResponse> createInserirResponse(InserirResponse value) {
        return new JAXBElement<InserirResponse>(_InserirResponse_QNAME, InserirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Excluir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "excluir")
    public JAXBElement<Excluir> createExcluir(Excluir value) {
        return new JAXBElement<Excluir>(_Excluir_QNAME, Excluir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Inserir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "inserir")
    public JAXBElement<Inserir> createInserir(Inserir value) {
        return new JAXBElement<Inserir>(_Inserir_QNAME, Inserir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarContatoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", name = "buscarContatoResponse")
    public JAXBElement<BuscarContatoResponse> createBuscarContatoResponse(BuscarContatoResponse value) {
        return new JAXBElement<BuscarContatoResponse>(_BuscarContatoResponse_QNAME, BuscarContatoResponse.class, null, value);
    }

}
