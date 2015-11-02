/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.servicoSoap;



import distribuidos.sistemas.trabalho.classes.Cep;
import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarCep;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import distribuidos.sistemas.trabalho.dao.InserirContato;
import distribuidos.sistemas.trabalho.dao.RemoverContato;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.swing.JOptionPane;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

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
    @WebMethod(operationName = "excluir")
    public boolean excluir(@WebParam(name = "codigo") int codigo) {
        Contato c = new Contato();
        c.setCodigo(codigo);
        RemoverContato r = new RemoverContato();
        if( r.remover(c)){
           return true;
        }
        else 
            return false;
       
              
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
    @WebMethod(operationName = "inserir")
    public boolean inserir(@WebParam(name = "contato") Contato contato) {
        InserirContato i =  new InserirContato();
        return i.inserir(contato);
        
                    
    }







}
