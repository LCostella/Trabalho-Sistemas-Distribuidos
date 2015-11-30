package chatudp;

import java.net.DatagramPacket;
import java.util.LinkedList;
import java.util.Queue;

public class ReceptorUDP {
    
    private static Queue<DatagramPacket> fila;
    private static ThreadInserirFila inserir;
    private static ThreadRetiraFila retirar;
    private static ThreadResponde responde;

    public Queue<DatagramPacket> getFila() {
        return fila;
    }

    public void setFila(Queue<DatagramPacket> fila) {
        this.fila = fila;
    }

    public ReceptorUDP() {
        
    }
    
    public static void main(String[] args) {
        Fila fila = new Fila();
        System.out.println("Chat");
        inserir = new ThreadInserirFila(fila, "inserir");
        retirar = new ThreadRetiraFila(fila, "retirar");
        responde = new ThreadResponde(fila, "responde");
        retirar.start();
        inserir.start();
        responde.start();
    }  
}
