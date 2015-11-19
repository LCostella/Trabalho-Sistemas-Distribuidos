/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptor.udp;

import distribuidos.sistemas.trabalho.classes.Cidade;
import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarCidade;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johni
 */
public class Listar {
    private Contato contato;
    private Cidade cidade;
    public Contato listar(List<String> dados) throws Exception{
        contato = new Contato();
        cidade = new Cidade();
        int i = 0;
        if(dados.get(i).equals("c")){ // Testa se for consultar
            i++;
            String nome = new String(dados.get(i));
            i++;
            String uf = new String(dados.get(i));
            i++;
            
            BuscarCidade ic = new BuscarCidade();
            cidade = ic.buscarCidade(nome, uf);
            BuscarContato bc = new BuscarContato();
            List<Contato> lc = new ArrayList<>();
            lc = bc.listar(cidade); // Todos os contatos que preciso mandar estão aqui
        }
        return contato;
}
}
