
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.servicosoap.Cep;

/**
 *
 * @author Leonardo
 */
public class BuscarCep {
    
    public Cep buscar(int cep){
            
     return buscarCep(cep);
}

    private static Cep buscarCep(int  cep) {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();
        return port.buscarCep(cep);
    }
    
    
}
