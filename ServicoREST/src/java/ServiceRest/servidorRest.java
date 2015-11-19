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
@Path("Rest")
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
    @Path("/buscarcep")
    public Cep buscarCep(@QueryParam("cep") int cep){
      Cep c = null;
        BuscarCep bc = new BuscarCep();
        try {       
            c= bc.buscarCep(cep);
        } catch (SQLException ex) {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
//       
   @GET
    @Produces("application/json")
    @Path("/contact")
     public Contato buscarContato(@QueryParam("contact") int contact) {
       Contato c= null;
       BuscarContato bc = new BuscarContato();
        try {      
            c =bc.buscarContato(contact);
        } catch (SQLException ex) {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }     
    //****** Did not handle BuscarCidade in client yet ***** 
    @GET
    @Produces("application/json")
    @Path("/buscarCidade")
    public Cidade buscarCidade(@QueryParam("nome") String nome, @QueryParam("estado") String estado) 
    {
        BuscarCidade bc = new BuscarCidade();
        try {
         return bc.buscarCidade(nome, estado);
        } catch (SQLException ex) 
        {
            Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//          
    @GET
    @Produces("application/json")
    @Path("/listcidade")
    public List<Cidade> listarCidade(){
        
        BuscarCidade bc = new BuscarCidade();
        try {
           return bc.listar();
        } catch (SQLException ex) {
           Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
//            
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listContatoPorCidade")
       public List<Contato> listarContato(@QueryParam("codigo") Integer codigo,
               @QueryParam("estado") String estado, @QueryParam("nome") String nome) {

       BuscarContato bc = new BuscarContato();
       try {
           Cidade cidade = new Cidade();
           cidade.setCodigo(codigo);
           cidade.setEstado(estado);
           cidade.setNome(nome);
           return bc.listar(cidade);
       } catch (SQLException ex) {
           Logger.getLogger(servidorRest.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    } 
    
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces("application/json")
     @Path("/inserirCep")
	public String inserirCep(@QueryParam("codigo") Integer codigo,
               @QueryParam("estado") String estado, 
               @QueryParam("nome") String nome, @QueryParam("cep") Integer cep)
        {
            Cep c = new Cep();
            Cidade cidade = new Cidade();
            cidade.setCodigo(codigo);
            cidade.setEstado(estado);
            cidade.setNome(nome);
            c.setCep(cep);
            c.setCidade(cidade);
            InserirCep ic = new InserirCep();
            boolean k;
            k = ic.inserir(c);
            if(k){
             return "SUCCESS! NEW CEP IS SAVED"; 
            }
            else {
             return "Fail! SOMETHING IS WRONG";
            }
        }
//   ****** Did not handle excluirContato in client yet ***** 
    @DELETE
    @Produces("application/xml")
    @Path("/excluirContato")
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
    
//   ****** Did not handle inserirContato in client yet *****
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces("application/json")
     @Path("/inserirContato")
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


//     
//     ****** Did not handle inserirCidade in client yet *****
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces("application/json")
     @Path("/inserirCidade")
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
//     ****** Did not handle alterarContato in client yet *****
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    @Path("/alterarContato")
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