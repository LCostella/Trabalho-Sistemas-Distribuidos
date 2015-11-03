/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.servicosoap.Contato;

/**
 *
 * @author felip
 */
public class InserirContato {
    public boolean inserir(Contato contato){
        return inserirContato(contato);
    }

    private static boolean inserirContato(distribuidos.sistemas.trabalho.servicosoap.Contato contato) {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();
        return port.inserirContato(contato);
    }
    
}
