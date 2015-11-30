/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptor.udp;

import distribuidos.sistemas.trabalho.classes.Cep;
import distribuidos.sistemas.trabalho.classes.Cidade;
import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarCep;
import distribuidos.sistemas.trabalho.dao.BuscarCidade;
import distribuidos.sistemas.trabalho.dao.InserirCep;
import distribuidos.sistemas.trabalho.dao.InserirCidade;
import distribuidos.sistemas.trabalho.dao.InserirContato;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class Inserir {
    private Contato contato;
    public boolean inserir(List<String> dados){
        contato = new Contato();
        int i = 0;
        if(dados.get(i).equals("a")){ // Testa se for adição, se for, popula o objeto com os dados proximos da lista
            i++;
            contato.setNome(dados.get(i));
            i++;
            contato.setEmail(dados.get(i).trim());
            i++;
            contato.setEndereco(dados.get(i));
            i++;
            contato.setComplemento(dados.get(i));
            i++;
            contato.setCep(getCep(dados.get(i).trim(), dados.get(i+1), dados.get(i+2)));// manda o cep e a cidade
            i = i+3;
            contato.setEmailAlternativo(dados.get(i).trim());
            
            InserirContato ic = new InserirContato();
            try {
                if(ic.inserir(contato)){
                    //System.out.println("Cadastrado com sucesso!");
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Inserir.class.getName()).log(Level.SEVERE, null, ex);
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
                    System.out.println("inseriu cidade nova");
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
                System.out.println("inseriu cep novo");
            }
            return cep;
        } catch (SQLException ex) {
            Logger.getLogger(Inserir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
