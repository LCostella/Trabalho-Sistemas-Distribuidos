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
public class Listar {
    List<String> dados = new ArrayList<>();
     public void list() throws Exception {
        dados.add("l");
        System.out.println("Digite a cidade:");
        Scanner entradac = new Scanner(System.in);
        String cidade = new String();
        cidade = entradac.next();
        dados.add(cidade);
        
        System.out.println("Digire o UF do estado");
        Scanner entradae = new Scanner(System.in);
        String estado = new String();
        estado = entradae.next();
        dados.add(estado);
        
        
        EnviarRecebe e = new EnviarRecebe();
        e.envia(dados);
        
    }
    
}
