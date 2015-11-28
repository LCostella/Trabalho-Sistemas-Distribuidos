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
        inserir.start();
        retirar.start();
    }  
}
