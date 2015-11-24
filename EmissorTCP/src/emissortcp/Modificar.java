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
public class Modificar {
    static void modify() throws Exception{
        
        List<String> operacao = new ArrayList<>();
        
        operacao.add("m");
        
        System.out.println("Digite o código do contato, o dado e a informação que deseja alterar de acordo com a especificação abaixo:");
        System.out.println("codigo/título da antiga informação/nova informação");
        //guardar resultado na variável 'modifica' 
        //como verificar se o usuário existe?
        //receber uma resposta para dar o ok para o usuário
        
        for (int i = 0; i < 3; ++i)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
            String aux = in.readLine();
            operacao.add(aux);
        }
        
        Enviar.envia(operacao);
    }
}
