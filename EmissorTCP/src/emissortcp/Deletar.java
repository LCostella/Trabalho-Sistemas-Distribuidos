/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emissortcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class Deletar {
    static void delete() throws Exception{
        List<String> operacao = new ArrayList<>();
        
        operacao.add("d");
        
        System.out.println("Digite o código do contato que deseja excluir:");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
        String aux = in.readLine();
        operacao.add(aux);
        //guardar resultado na variável 'exclui'
        //como verificar se o usuário existe?
        //receber uma resposta para dar o ok para o usuário
        
        Enviar.envia(operacao);
    }
}
