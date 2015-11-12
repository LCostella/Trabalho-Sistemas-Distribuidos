/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceRest;

import distribuidos.sistemas.trabalho.classes.Cep;
import distribuidos.sistemas.trabalho.classes.Cidade;
import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.AlterarContato;
import distribuidos.sistemas.trabalho.dao.BuscarCep;
import distribuidos.sistemas.trabalho.dao.BuscarCidade;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import distribuidos.sistemas.trabalho.dao.InserirCep;
import distribuidos.sistemas.trabalho.dao.InserirCidade;
import distribuidos.sistemas.trabalho.dao.InserirContato;
import distribuidos.sistemas.trabalho.dao.RemoverContato;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Bola de Pelos
 */
@Path("rest")
public class servidorRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of servidorRest
     */
    public servidorRest() {
    }

    /**
     * Retrieves representation of an instance of ServiceRest.servidorRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces("application/json")
    @Path("Rest/Cep/buscar/{cep}")
    public Cep buscarCep(@PathParam("cep") int cep){
      Cep c = null;
        BuscarCep bc = new BuscarCep();
        try {       
            c= bc.buscarCep(cep);
        } catch (SQLException ex) {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    
    @GET
    @Produces("application/json")
    @Path("Rest/Contato/buscar/{codigo}")
     public Contato buscarContato(@PathParam("codigo") int codigo) {
       Contato c= null;
       BuscarContato bc = new BuscarContato();
        try {      
            c =bc.buscarContato(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return c;
    }
     
     
     
     
       @GET
       @Produces("application/json")
       @Path("Rest/Cidade/buscar/{nome}/{estado}")
       public Cidade buscarCidade(@PathParam("nome") String nome, @PathParam("estado") String estado) {
        BuscarCidade bc = new BuscarCidade();
        try {
            return bc.buscarCidade(nome, estado);
        } catch (SQLException ex) {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
     @GET
     @Produces("application/json")
     @Path("Rest/listcidade")
      public List<Cidade> listarCidade(){
     
        BuscarCidade bc = new BuscarCidade();
        try {
            return bc.listar();
        } catch (SQLException ex) {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
 
    }
      
      
      
      
     @PUT
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     @Path("Rest/listContatoPorCidade")
        public List<Contato> listarContato(Cidade cidade) {
        
        BuscarContato bc = new BuscarContato();
        try {
            
            return bc.listar(cidade);
        } catch (SQLException ex) {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    @DELETE
     @Produces("application/xml")
     @Path("Rest/Contato/delete/{codigo}")
     public String excluirContato(@PathParam("codigo") int codigo) {
        Contato c = new Contato();
        c.setCodigo(codigo);
        RemoverContato r = new RemoverContato();
        boolean k = false;
        k = r.remover(c);
        if(k)
            return "OK";
        else 
            return "FAIL";
     }
    
    

     
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces("application/json")
     @Path("Rest/Contato/inserir")
     public String inserirContato(Contato contato){
         
        
         Contato c = new Contato();
         InserirContato ic = new InserirContato();
         boolean k;
         k = ic.inserir(contato);
         if(k){
             return"OK";
             
         }else {
             return "Fail";
         }
         
     }
     
     
     
     
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces("application/json")
     @Path("Rest/Cep/inserir")
     public String inserirCep(Cep cep){
         
        
         Cep c = new Cep();
         InserirCep ic = new InserirCep();
         boolean k;
         k = ic.inserir(cep);
         if(k){
             return"OK";
             
         }else {
             return "Fail";
         }
         
     }
     
     
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces("application/json")
     @Path("Rest/Cidade/inserir")
     public String inserirCidade(Cidade cidade){
         
        
         Cidade c = new Cidade();
         InserirCidade ic = new InserirCidade();
         boolean k;
         k = ic.inserir(cidade);
         if(k){
             return"OK";
             
         }else {
             return "Fail";
         }
         
     }
     
    @PUT
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces("application/json")
     @Path("Rest/Contato/alterar")
    public String alterarContato(Contato contato) {
        AlterarContato ac = new AlterarContato();
        
        boolean k;
        k =  ac.alterar(contato);
        if(k){
             return"OK";
             
         }else {
             return "Fail";
         }
    }
     
     
     
     
     
}
    

