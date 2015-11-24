/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;


import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import distribuidos.sistemas.trabalho.dao.InserirContato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Emanoel
 */
public class Consultar {
    private Contato contato;
    public Contato consultar(List<String> dados) throws Exception{
        contato = new Contato();
        int i = 0;
        if(dados.get(i).equals("c")){ // Testa se for consultar
            i++;
            int codigo; 
            codigo = Integer.parseInt(dados.get(i));
            //i++;
            
            BuscarContato ic = new BuscarContato();
            contato = ic.buscarContato(codigo);
        }
        return contato;
    }
}