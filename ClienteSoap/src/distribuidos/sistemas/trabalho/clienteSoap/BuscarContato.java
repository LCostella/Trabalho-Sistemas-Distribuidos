
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.servicosoap.Cidade;
import distribuidos.sistemas.trabalho.servicosoap.Contato;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class BuscarContato {
    
    public Contato buscar(int codigo ){
        return buscarContato(codigo);
        
    }

    private static Contato buscarContato(int codigo) {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();
        return port.buscarContato(codigo);
    }

       public List<Contato> listar(CidadeSOAP cidade){
       distribuidos.sistemas.trabalho.servicosoap.Cidade c = new distribuidos.sistemas.trabalho.servicosoap.Cidade();
       c.setNome(cidade.getNome());
       c.setCodigo(cidade.getCodigo());
       c.setEstado(cidade.getEstado());
       return listarContato(c);
   }
       
       private static List<Contato> listarContato(Cidade cidade) {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();
        return port.listarContato(cidade);
    }
}

   
    
    

