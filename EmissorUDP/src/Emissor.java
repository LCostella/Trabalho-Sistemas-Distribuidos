
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
                    modify();
                    break;
                case 'd': //DELETE
                    System.out.println("Você escolheu a opcao Excluir.");
                    delete();
                    break;
                case 'c': //CONSULT
                    System.out.println("Você escolheu a opcao Consultar.");
                    consult();
                    break;
                case 'l': //LIST
                    System.out.println("Você escolheu a opcao Listar Cidade.");
                    list();
                    break;
            }
        
        }while(op == 's');
    }

    
    private static void envia(String msg) throws Exception{
        int porta = 2010;
        String host = new String("localhost");
        byte data[] = new byte[1000];
        InetAddress address = InetAddress.getByName(host);
        
        data = msg.getBytes();
        
        System.out.println("Emissor");
        
        System.out.println("Instanciando Socket");
        DatagramSocket soc = new DatagramSocket();
        System.out.println("Instanciando o pacote a ser enviado");
        DatagramPacket pct = new DatagramPacket(data, data.length, address, porta);
    
        soc.send(pct);
        System.out.println("Enviou mensagem");
        
        soc.close();
    }
    
    private static void add() throws Exception{
        String adiciona = new String();
        System.out.println("Digite as informacoes que deseja adicionar ao banco de dados na seguinte ordem:");
        System.out.println("codigo/nome/email/endereco/complemento/cep/cidade/estado/email alternativo");
        //guardar resultado na variável 'adiciona'
        envia("a/" + adiciona);
        //receber uma resposta para dar o ok para o usuário
    }

    private static void modify() throws Exception{
        String modifica = new String();
        System.out.println("Digite o código do contato, o dado e a informação que deseja alterar de acordo com a especificação abaixo:");
        System.out.println("codigo/título da antiga informação/nova informação");
        //guardar resultado na variável 'modifica' 
        //como verificar se o usuário existe?
        //receber uma resposta para dar o ok para o usuário
        
        envia("m/" + modifica);
    }

    private static void delete() throws Exception{
        String exclui = new String();
        System.out.println("Digite o código do contato que deseja excluir:");
        //guardar resultado na variável 'exclui'
        //como verificar se o usuário existe?
        //receber uma resposta para dar o ok para o usuário
        
        envia("d/" + exclui);
    }

    private static void consult() throws Exception{
        String consulta = new String();
        System.out.println("Digite o código do contado que deseja pesquisar:");
        //guardar resultado na variável 'consulta'
        //como verificar se o usuário existe?
        //receber uma resposta para mostrar ao usuário
        
        envia("c/" + consulta);
    }

    private static void list() throws Exception{
        String lista = new String();
        System.out.println("Digite a cidade da qual deseja obter a lista de contatos:");
        //guardar resultado na variável 'lista'
        //como verificar se o usuário existe?
        //receber uma resposta para mostrar ao usuário
        
        envia("l/" + lista);
    }
    
}
