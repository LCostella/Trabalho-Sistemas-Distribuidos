
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
public class ListarCidade {
    public void list() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String lista = new String();
        System.out.println("Digite a cidade da qual deseja obter a lista de contatos de acordo com a especificação abaixo:");
        System.out.println("cidade/estado");
        lista = entrada.nextLine();//guardar resultado na variável 'lista'
        
        lista ="l/".concat(lista);
        Enviar e = new Enviar();
        e.envia(lista);
        
    }
    
}
