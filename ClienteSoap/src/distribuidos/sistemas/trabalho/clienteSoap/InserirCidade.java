/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.servicosoap.Cidade;

/**
 *
 * @author felip
 */
public class InserirCidade {
    public boolean inserir(Cidade cidade){
        return inserirCidade(cidade);
    }

    private static boolean inserirCidade(distribuidos.sistemas.trabalho.servicosoap.Cidade cidade) {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();
        return port.inserirCidade(cidade);
    }


    
}
