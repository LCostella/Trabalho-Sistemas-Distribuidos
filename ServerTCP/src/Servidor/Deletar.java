/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.RemoverContato;
import java.util.List;

/**
 *
 * @author Emanoel
 */
public class Deletar {
    private Contato contato;
    public boolean deletar(List<String> dados){
        contato = new Contato();
        int i = 0, codigo;
        if(dados.get(i).equals("d")){ // Testa se for deletar
            i++;
            codigo = Integer.parseInt(dados.get(i));
            contato.setCodigo(codigo);
            
            RemoverContato ic = new RemoverContato();
            if(ic.remover(contato)){
                return true;
            }
        }
        return false;
    }
}