/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.clienteSoap.telas.TelaPrincipal;
import distribuidos.sistemas.trabalho.servicosoap.Cep;

/**
 *
 * @author Leonardo
 */
public class ClienteSoap {
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cep  cep = new Cep();
        TelaPrincipal t = new TelaPrincipal();
        t.setVisible(true);
    }
    
}
