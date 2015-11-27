
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manoela
 */
public class Consultar {
    public void consult() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String consulta = new String();
        System.out.println("Digite a cidade e o estado que deseja pesquisar:");
        consulta = entrada.next();//guardar resultado na variável 'consulta'
        
        Enviar e = new Enviar();
        e.envia("c/" + consulta);
    }
    
}
