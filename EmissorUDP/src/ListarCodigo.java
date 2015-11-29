
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
public class ListarCodigo {
    public void listcod() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String lista = new String();
        System.out.println("Digite o código do qual deseja obter a lista de contatos:");
        lista = entrada.nextLine();//guardar resultado na variável 'lista'
        
        Enviar e = new Enviar();
        e.envia("lc/" + lista);
        
    }
}
