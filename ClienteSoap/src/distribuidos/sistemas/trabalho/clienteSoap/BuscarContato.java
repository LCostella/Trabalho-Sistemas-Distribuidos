
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.servicosoap.Contato;

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

    
    }

   
    
    

