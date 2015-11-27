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
public class Listar {
    static void list() throws Exception{
        List<String> operacao = new ArrayList<>();
        
        operacao.add("d");
        
        System.out.println("Digite a cidade da qual deseja obter a lista de contatos:");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
        String aux = in.readLine();
        operacao.add(aux);
        //guardar resultado na variável 'lista'
        //como verificar se o usuário existe?
        //receber uma resposta para mostrar ao usuário
        
        Enviar.envia(operacao);
    }
}
