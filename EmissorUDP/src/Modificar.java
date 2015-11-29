
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
public class Modificar {
    public void modify() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String modifica = new String();
        System.out.println("Digite o código do contato, o dado e a informação que deseja alterar de acordo com a especificação abaixo:");
        System.out.println("codigo/nome/email/endereco/complemento/cep/cidade/estado/email alternativo");
        modifica = entrada.nextLine();//guardar resultado na variável 'modifica' 
        
        Enviar e = new Enviar();
        e.envia("m/" + modifica);        

    }
    
}
