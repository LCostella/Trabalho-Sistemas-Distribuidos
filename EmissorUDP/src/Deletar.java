
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
public class Deletar {
    public void delete() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String exclui = new String();
        System.out.println("Digite o código do contato que deseja excluir:");
        exclui = entrada.next();//guardar resultado na variável 'exclui'
        
        Enviar e = new Enviar();
        e.envia("d/" + exclui);
        
    }
    
}
