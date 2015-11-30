/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptor.udp;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.RemoverContato;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johni
 */
public class Deletar {
    private Contato contato;
    public boolean deletar(List<String> dados){
        contato = new Contato();
        int i = 0;
        if(dados.get(i).equals("d")){ // Testa se for deletar
            i++;
            contato.setCodigo((Integer.parseInt(dados.get(i).trim())));

            RemoverContato ic = new RemoverContato();
            try {
                if(ic.remover(contato)){
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Deletar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
