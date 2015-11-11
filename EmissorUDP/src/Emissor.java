
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
public class Emissor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        char op = 'o';
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("-------- EMISSOR UDP ---------");
        System.out.println(" ");
        System.out.println("Selecione a opção desejada:");
        System.out.println(" ");
        System.out.println("Adicionar (add) --------> a");
        System.out.println("Alterar (modify) -------> m");
        System.out.println("Excluir (delete) -------> d");
        System.out.println("Consultar (consult) ----> c");
        System.out.println("Listar Cidades (list) --> l");
        System.out.println("SAIR (exit) ------------> e");
        
        op = entrada.next().charAt(0);
                
        do {
            switch (op) {
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
                case 'e': //EXIT
                    System.out.println("Você escolheu a opção sair.");
                    break;
            }

        } while (op == 'e');

    }

    private static void envia(String msg) throws Exception {
        String msg_resposta = "";
        int porta = 2010;
        String host = new String("localhost");
        byte data[] = new byte[1000];
        msg = (porta + "|Hello Word");
        data = msg.getBytes();

        System.out.println("...EMITINDO...");

        InetAddress address;
        DatagramSocket soc;
        DatagramPacket pct;

        System.out.println("Inicializando InetAdress");
        try {
            address = InetAddress.getByName(host);
            msg_resposta = "Inicializou InetAdress";
        } catch (Exception e) {
            msg_resposta = "Não Inicializou InetAdress";
            return;
        } finally {
            System.out.println(msg_resposta);
        }

        System.out.println("Instanciando Socket");
        try {
            soc = new DatagramSocket();
            msg_resposta = "Inicializou Datagrama Socket";
        } catch (Exception e) {
            msg_resposta = "Não Inicializou Datagrama Socket";
            return;
        } finally {
            System.out.println(msg_resposta);
        }

        System.out.println("Instanciando o pacote a ser enviado");
        try {
            pct = new DatagramPacket(data, data.length, address, porta);
            msg_resposta = "Inicializou Datagrama Packet";
        } catch (Exception e) {
            msg_resposta = "Não Inicializou Datagrama Packet";
            return;
        } finally {
            System.out.println(msg_resposta);
        }

        try {
            soc.send(pct);
            msg_resposta = "Enviou Mensagem";
        } catch (Exception e) {
            msg_resposta = "Não Foi possível enviar mensagem";
        } finally {
            System.out.println(msg_resposta);
        }

    }

    private static String recebe() {
        int porta = 2010;
        String host = new String("localhost");
        DatagramPacket pct;
        byte data[] = new byte[1000];
        InetAddress address;
        DatagramSocket soc;

        String resposta;
        String msg_resposta = "";

        System.out.println("Inicializando InetAdress");
        try {
            address = InetAddress.getByName(host);
            msg_resposta = "Inicializou InetAdress";
        } catch (Exception e) {
            msg_resposta = "Não Inicializou InetAdress";
            return "er";
        } finally {
            System.out.println(msg_resposta);
        }

        System.out.println("Instanciando Socket");
        try {
            soc = new DatagramSocket();
            msg_resposta = "Inicializou Datagrama Socket";
        } catch (Exception e) {
            msg_resposta = "Não Inicializou Datagrama Socket";
            return "er";
        } finally {
            System.out.println(msg_resposta);
        }

        System.out.println("...RECEBENDO...");

        System.out.println("Aguarda mensagem");

        System.out.println("Instanciando o pacote a ser recebido");
        try {
            pct = new DatagramPacket(data, data.length, address, porta);
            msg_resposta = "Inicializou Datagrama Packet";
        } catch (Exception e) {
            msg_resposta = "Não Inicializou Datagrama Packet";
            return "er";
        } finally {
            System.out.println(msg_resposta);
        }

        try {
            soc.receive(pct);
            resposta = new String(pct.getData(), 0, pct.getLength());
            msg_resposta = "Recebeu Mensagem";
        } catch (Exception e) {
            msg_resposta = "Não Foi possível receber mensagem";
            return "er";
        } finally {
            System.out.println(msg_resposta);
        }

        soc.close();

        return resposta;
    }

    private static void add() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String adiciona = new String();
        System.out.println("Digite as informacoes que deseja adicionar ao banco de dados na seguinte ordem:");
        System.out.println("codigo/nome/email/endereco/complemento/cep/cidade/estado/email alternativo");
        adiciona = entrada.next(); //guardar resultado na variável 'adiciona'
        envia("a/" + adiciona);

        if (recebe() == "ok") //receber uma resposta para dar o ok para o usuário
        {
            System.out.println("Dados cadastrados com sucesso!");
        } else if (recebe() == "er") {
            System.out.println("Erro: repita o procedimento.");
        }
    }

    private static void modify() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String modifica = new String();
        System.out.println("Digite o código do contato, o dado e a informação que deseja alterar de acordo com a especificação abaixo:");
        System.out.println("codigo/título da antiga informação/nova informação");
        modifica = entrada.next();//guardar resultado na variável 'modifica' 

        envia("m/" + modifica);

        if (recebe() == "ne")//verificar se o cadastro existe
        {
            System.out.println("Cadastro não existente!");
        } else if (recebe() == "ok") {
            System.out.println("Cadastro alterado com sucesso!");//receber uma resposta para dar o ok para o usuário
        } else if (recebe() == "er") {
            System.out.println("Erro: repita o procedimento.");
        }

    }

    private static void delete() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String exclui = new String();
        System.out.println("Digite o código do contato que deseja excluir:");
        exclui = entrada.next();//guardar resultado na variável 'exclui'

        envia("d/" + exclui);

        if (recebe() == "ne")//verificar se o cadastro existe
        {
            System.out.println("Cadastro não existente!");
        } else if (recebe() == "ok") {
            System.out.println("Cadastro excluido com sucesso!");//receber uma resposta para dar o ok para o usuário
        } else if (recebe() == "er") {
            System.out.println("Erro: repita o procedimento.");
        }
    }

    private static void consult() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String consulta = new String();
        System.out.println("Digite o código do contado que deseja pesquisar:");
        consulta = entrada.next();//guardar resultado na variável 'consulta'

        envia("c/" + consulta);

        if (recebe() == "ne")//verificar se o cadastro existe
        {
            System.out.println("Cadastro não existente!");
        } else if (recebe() == "er") {
            System.out.println("Erro: repita o procedimento.");
        } else {
            System.out.println("Resultado da pesquisa: " + recebe());
        }
    }

    private static void list() throws Exception {
        Scanner entrada = new Scanner(System.in);
        String lista = new String();
        System.out.println("Digite a cidade da qual deseja obter a lista de contatos:");
        lista = entrada.next();//guardar resultado na variável 'lista'

        envia("l/" + lista);

        if (recebe() == "ne")//verificar se o cadastro existe
        {
            System.out.println("Cadastro não existente!");
        } else if (recebe() == "er") {
            System.out.println("Erro: repita o procedimento.");
        } else {
            System.out.println("Resultado da pesquisa: " + recebe());
        }
    }

}
