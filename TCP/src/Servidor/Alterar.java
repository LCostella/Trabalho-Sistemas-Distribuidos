/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import distribuidos.sistemas.trabalho.classes.Cep;
import distribuidos.sistemas.trabalho.classes.Cidade;
import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.AlterarContato;
import distribuidos.sistemas.trabalho.dao.BuscarCep;
import distribuidos.sistemas.trabalho.dao.BuscarCidade;
import distribuidos.sistemas.trabalho.dao.InserirCep;
import distribuidos.sistemas.trabalho.dao.InserirCidade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanoel
 */
public class Alterar {
     private Contato contato;
    public boolean alterar(List<String> dados){
        contato = new Contato();
        int i = 0;
        if(dados.get(i).equals("m")){ // Testa se for alterar
            i++;
            contato.setCodigo((Integer.getInteger(dados.get(i))));
            i++;
            contato.setNome(dados.get(i));
            i++;
            contato.setEmail(dados.get(i));
            i++;
            contato.setEndereco(dados.get(i));
            i++;
            contato.setComplemento(dados.get(i));
            i++;
            contato.setCep(getCep(dados.get(i), dados.get(i+1), dados.get(i+2)));// manda o cep e a cidade

            AlterarContato ic = new AlterarContato();
            if(ic.alterar(contato)){
                return true;
            }
        }
 
        return false;
}

     private Cep getCep(String c , String cidade , String estado){
        try {
            Cep cep;
            Cidade cid;
            //busca cep
            BuscarCep bc = new BuscarCep();
            cep = bc.buscarCep(Integer.parseInt(c.trim()));
            if(cep== null){
                //se nao encontrou o cep busca a cidade
                
                //busca a cidade pelo nome estado
                BuscarCidade buscarCidade = new BuscarCidade();
                cid = buscarCidade.buscarCidade(cidade,estado);
                if(cid == null){
                    //se nao encontrou cria uma nova
                    cid = new Cidade();
                    cid.setNome(cidade);
                    cid.setEstado(estado);
                    InserirCidade ic = new InserirCidade();
                    if(!ic.inserir(cid)){
                        System.out.println("Erro ao cadastrar cidade!");
                        return null;
                    }
                }
                //cria novo cep e adiciona a cidade
                cep = new Cep();
                cep.setCep(Integer.parseInt(c.trim()));
                cep.setCidade(cid);
                InserirCep inserirCep = new InserirCep();
                if(!inserirCep.inserir(cep)){
                    System.out.println("Erro ao cadastrar cep!");
                    return null;
                }
            }
            return cep;
        } catch (SQLException ex) {
            Logger.getLogger(Inserir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}