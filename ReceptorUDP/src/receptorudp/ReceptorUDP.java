package receptorudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.Queue;

public class ReceptorUDP {

    public static void main(String[] args) throws Exception {
        int porta = 2010;
        byte data[] = new byte[400];
        Queue<DatagramPacket> fila = new LinkedList<>(); // Instancio uma fila de DatagramPacket
        String msg;
        
        System.out.println("Receptor");
        
        System.out.println("Instanciou Socket");
        DatagramSocket soc = new DatagramSocket(porta); // Instancia um DatagramSocket
        DatagramPacket pct = new DatagramPacket(data, data.length); // Instancia um DatagramPacket
        
        System.out.println("Aguarda mensagem");
        soc.receive(pct); // Socket fica aguardando receber a mensagem
        msg = new String(pct.getData()); // Jogo em uma String apenas para teste
        System.out.println("Recebido teste : " + msg); // Mostro apenas para teste
        fila.add(pct); // Guardo o datagrama na fila
        
    }
    
}
