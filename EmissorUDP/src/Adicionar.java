
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
public class Adicionar {
      public void add() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String adiciona = new String();
        System.out.println("Digite as informacoes que deseja adicionar ao banco de dados na seguinte ordem:");
        System.out.println("nome/email/endereco/complemento/cep/cidade/estado/email alternativo");
        adiciona = entrada.next(); //guardar resultado na variável 'adiciona'
        System.out.println("Mostrando resultado da variável adiciona:" + adiciona);
        
        Enviar e = new Enviar();
        e.envia("a/" + adiciona);

        
    }
}
