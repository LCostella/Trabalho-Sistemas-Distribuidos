
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manoela
 */
public class Emissor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int porta = 2010;
        String host = new String("localhost");
        byte data[] = new byte[1000];
        String msg;
        InetAddress address = InetAddress.getByName(host);
        msg = new String();
        data = msg.getBytes();
        
        
        menu();        
        
        
    }

    private static void menu() throws Exception{
        char op = 'o';
        System.out.println("EMISSOR UDP");
        System.out.println("Selecione a opção desejada:");
        System.out.println("Adicionar (add) - a");
        System.out.println("Alterar (modify) - m");
        System.out.println("Excluir (delete) - d");
        System.out.println("Consultar (consult) - c");
        System.out.println("Listar Cidades (list) - l");
        
        do{
            switch (op){
                case 'a': //ADD
                    System.out.println("Você escolheu a opcao Adicionar.");
                    add();
                    break;
                case 'm': //MODIFY
                    System.out.println("Você escolheu a opcao Alterar.");
                    break;
                case 'd': //DELETE
                    System.out.println("Você escolheu a opcao Excluir.");
                    break;
                case 'c': //CONSULT
                    System.out.println("Você escolheu a opcao Consultar.");
                    break;
                case 'l': //LIST
                    System.out.println("Você escolheu a opcao Listar.");
                    break;
            }
        
        }while(op == 's');
    }

    private static void add() throws Exception{
        String adiciona = new String();
        System.out.println("Digite as informacoes que deseja adicionar ao banco de dados na seguinte ordem:");
        System.out.println("codigo/nome/email/endereco/complemento/cep/cidade/estado/email alternativo");
        //guardar resultado na variável 'adiciona'
    }
    
}
