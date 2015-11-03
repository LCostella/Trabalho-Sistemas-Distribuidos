/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.servicoSoap;



import distribuidos.sistemas.trabalho.classes.Cep;
import distribuidos.sistemas.trabalho.classes.Cidade;
import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarCep;
import distribuidos.sistemas.trabalho.dao.BuscarCidade;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import distribuidos.sistemas.trabalho.dao.InserirCep;
import distribuidos.sistemas.trabalho.dao.InserirCidade;
import distribuidos.sistemas.trabalho.dao.InserirContato;
import distribuidos.sistemas.trabalho.dao.RemoverContato;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 *
 * @author Leonardo
 */
@WebService(serviceName = "CalculatorWS")
@Stateless()
public class ServidorSoapSD {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "excluirContato")
    public boolean excluirContato(@WebParam(name = "codigo") int codigo) {
        Contato c = new Contato();
        c.setCodigo(codigo);
        RemoverContato r = new RemoverContato();
        return r.remover(c);      
              
    }
    /**
     * Operação de Web service para buscar o Cep 
     * @param cep
     * @return 
     */
    @WebMethod(operationName = "buscarCep")
    public Cep buscarCep(@WebParam(name = "cep") int cep)  {
       
        Cep c = null;
        BuscarCep bc = new BuscarCep();
        try {       
            c= bc.buscarCep(cep);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorSoapSD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  c;
    }
  


    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "buscarContato")
    public Contato buscarContato(@WebParam(name = "codigo") int codigo) {
       Contato c= null;
       BuscarContato bc = new BuscarContato();
        try {      
            c =bc.buscarContato(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorSoapSD.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return c;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "inserirContato")
    public boolean inserirContato(@WebParam(name = "contato") Contato contato) {
        InserirContato i =  new InserirContato();
        return i.inserir(contato);             
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "inserirCep")
    public boolean inserirCep(@WebParam(name = "cep") Cep cep) {
        InserirCep ic = new InserirCep();
        return ic.inserir(cep);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "inserirCidade")
    public boolean inserirCidade(@WebParam(name = "cidade") Cidade cidade) {
        InserirCidade ic = new InserirCidade();
        return ic.inserir(cidade);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "buscarCidade")
    public Cidade buscarCidade(@WebParam(name = "nome") String nome, @WebParam(name = "estado") String estado) {
        BuscarCidade bc = new BuscarCidade();
        try {
            return bc.buscarCidade(nome, estado);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorSoapSD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
