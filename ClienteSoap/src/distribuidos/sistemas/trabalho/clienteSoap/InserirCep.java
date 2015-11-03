/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.servicosoap.Cep;

/**
 *
 * @author felip
 */
public class InserirCep {
    public boolean inserir(Cep cep){
        return inserirCep(cep);
    }

    private static boolean inserirCep(distribuidos.sistemas.trabalho.servicosoap.Cep cep) {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();
        return port.inserirCep(cep);
    }
    
}
