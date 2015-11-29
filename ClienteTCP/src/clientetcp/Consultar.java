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
 * @author Emanoel
 */
public class Consultar {
    List<String> dados = new ArrayList<>();
    public void consult() throws Exception {
        dados.add("c");
        Scanner entrada = new Scanner(System.in);
        String consulta = new String();
        System.out.println("Digite a o codigo deseja pesquisar:");
        consulta = entrada.next();
     
        dados.add(consulta);
        EnviarRecebe e = new EnviarRecebe();
        e.envia(dados);
    }
    
}
