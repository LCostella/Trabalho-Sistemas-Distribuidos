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
public class Adicionar {
    static void add() throws Exception{
        List<String> operacao = new ArrayList<>();
        
        operacao.add("a");
        System.out.println("Digite as informacoes que deseja adicionar ao banco de dados na seguinte ordem:");
        System.out.println("codigo/nome/email/endereco/complemento/cep/cidade/estado/email alternativo");
        for (int i = 0; i < 9; ++i)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
            String aux = in.readLine();
            operacao.add(aux);
        }
        //guardar resultado na variável 'adiciona'
        Enviar.envia(operacao);
        //receber uma resposta para dar o ok para o usuário
    }
}
