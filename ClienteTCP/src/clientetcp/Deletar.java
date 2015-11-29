/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientetcp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matheus
 */
public class Deletar {
    List<String> dados = new ArrayList<>();
      public void delete() throws Exception {
        dados.add("d");
        Scanner entrada = new Scanner(System.in);
        String exclui = new String();
        System.out.println("Digite o código:");
        exclui = entrada.next();
        dados.add(exclui);
        EnviarRecebe e = new EnviarRecebe();
        e.envia(dados);
        
    }
    
}
