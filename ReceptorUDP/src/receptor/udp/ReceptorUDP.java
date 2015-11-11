package receptor.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReceptorUDP {
    
    private static Queue<DatagramPacket> fila;
    private static ThreadInserirFila inserir;
    private static ThreadRetiraFila retirar;

    public Queue<DatagramPacket> getFila() {
        return fila;
    }

    public void setFila(Queue<DatagramPacket> fila) {
        this.fila = fila;
    }

    public ReceptorUDP() {
        
    }
    
    public static void main(String[] args) {
        //inicia a fila e as threads
        fila = new LinkedList<>();
        inserir = new ThreadInserirFila(fila, "inserir");
        retirar = new ThreadRetiraFila(fila, "retirar");
    }
//    public static void main(String[] args) throws Exception {
//        int porta = 2010;
//        byte data[] = new byte[400];
//        Queue<DatagramPacket> fila = new LinkedList<>(); // Instancio uma fila de DatagramPacket
//        List<String> dados = new ArrayList<>(); // Lista para guardar os dados recebidos
//        String msg;
//        
//        System.out.println("Receptor");
//        
//        System.out.println("Instanciou Socket");
//        DatagramSocket soc = new DatagramSocket(porta); // Instancia um DatagramSocket
//        DatagramPacket pct = new DatagramPacket(data, data.length); // Instancia um DatagramPacket
//        
//        System.out.println("Aguarda mensagem");
//        soc.receive(pct); // Socket fica aguardando receber a mensagem
//        msg = new String(pct.getData()); // Jogo em uma String apenas para teste
//        System.out.println("Recebido teste : " + msg); // Mostro apenas para teste
//        fila.add(pct); // Guardo o datagrama na fila
//        
//        msg = new String(fila.poll().getData()); // Retiro o datagrama da fila e guardo ele inteiro em uma string
//        
//        String dado = new String(); // Instancio uma String para ir concatenando os caracteres
//        for(int i=0; i<msg.length(); i++){ // Percorre a string inteira
//            char c = msg.charAt(i); // Jogo cada caracter da string em uma variavel caracter
//            if(c!='/') // Se for diferente de /
//                dado = dado + c; // Concatena
//            else{ // Se for igual a /(significa que ta separando o dado)
//                dados.add(dado); //  Joga a String concatenada em uma lista(é um dado inteiro)
//                dado = ""; // "Esvazia" a string para começar a concatenar denovo
//            }
//        }   
//    }  
}
