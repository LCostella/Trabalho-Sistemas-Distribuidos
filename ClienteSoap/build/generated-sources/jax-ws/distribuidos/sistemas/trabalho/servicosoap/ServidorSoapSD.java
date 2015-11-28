
package distribuidos.sistemas.trabalho.servicosoap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServidorSoapSD", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServidorSoapSD {


    /**
     * 
     * @return
     *     returns java.util.List<distribuidos.sistemas.trabalho.servicosoap.Cidade>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarCidade", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.ListarCidade")
    @ResponseWrapper(localName = "listarCidadeResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.ListarCidadeResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/listarCidadeRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/listarCidadeResponse")
    public List<Cidade> listarCidade();

    /**
     * 
     * @param cidade
     * @return
     *     returns java.util.List<distribuidos.sistemas.trabalho.servicosoap.Contato>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarContato", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.ListarContato")
    @ResponseWrapper(localName = "listarContatoResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.ListarContatoResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/listarContatoRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/listarContatoResponse")
    public List<Contato> listarContato(
        @WebParam(name = "cidade", targetNamespace = "")
        Cidade cidade);

    /**
     * 
     * @param cep
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "inserirCep", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.InserirCep")
    @ResponseWrapper(localName = "inserirCepResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.InserirCepResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/inserirCepRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/inserirCepResponse")
    public boolean inserirCep(
        @WebParam(name = "cep", targetNamespace = "")
        Cep cep);

    /**
     * 
     * @param cep
     * @return
     *     returns distribuidos.sistemas.trabalho.servicosoap.Cep
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarCep", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.BuscarCep")
    @ResponseWrapper(localName = "buscarCepResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.BuscarCepResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/buscarCepRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/buscarCepResponse")
    public Cep buscarCep(
        @WebParam(name = "cep", targetNamespace = "")
        int cep);

    /**
     * 
     * @param codigo
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "excluirContato", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.ExcluirContato")
    @ResponseWrapper(localName = "excluirContatoResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.ExcluirContatoResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/excluirContatoRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/excluirContatoResponse")
    public boolean excluirContato(
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo);

    /**
     * 
     * @param contato
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "inserirContato", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.InserirContato")
    @ResponseWrapper(localName = "inserirContatoResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.InserirContatoResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/inserirContatoRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/inserirContatoResponse")
    public boolean inserirContato(
        @WebParam(name = "contato", targetNamespace = "")
        Contato contato);

    /**
     * 
     * @param codigo
     * @return
     *     returns distribuidos.sistemas.trabalho.servicosoap.Contato
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarContato", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.BuscarContato")
    @ResponseWrapper(localName = "buscarContatoResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.BuscarContatoResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/buscarContatoRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/buscarContatoResponse")
    public Contato buscarContato(
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo);

    /**
     * 
     * @param estado
     * @param nome
     * @return
     *     returns distribuidos.sistemas.trabalho.servicosoap.Cidade
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarCidade", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.BuscarCidade")
    @ResponseWrapper(localName = "buscarCidadeResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.BuscarCidadeResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/buscarCidadeRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/buscarCidadeResponse")
    public Cidade buscarCidade(
        @WebParam(name = "nome", targetNamespace = "")
        String nome,
        @WebParam(name = "estado", targetNamespace = "")
        String estado);

    /**
     * 
     * @param contato
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alterarContato", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.AlterarContato")
    @ResponseWrapper(localName = "alterarContatoResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.AlterarContatoResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/alterarContatoRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/alterarContatoResponse")
    public boolean alterarContato(
        @WebParam(name = "contato", targetNamespace = "")
        Contato contato);

    /**
     * 
     * @param cidade
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "inserirCidade", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.InserirCidade")
    @ResponseWrapper(localName = "inserirCidadeResponse", targetNamespace = "http://servicoSoap.trabalho.sistemas.distribuidos/", className = "distribuidos.sistemas.trabalho.servicosoap.InserirCidadeResponse")
    @Action(input = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/inserirCidadeRequest", output = "http://servicoSoap.trabalho.sistemas.distribuidos/ServidorSoapSD/inserirCidadeResponse")
    public boolean inserirCidade(
        @WebParam(name = "cidade", targetNamespace = "")
        Cidade cidade);

}
