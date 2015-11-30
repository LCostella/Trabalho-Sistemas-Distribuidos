package chatudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johni
 */
public class ThreadInserirFila extends Thread{
    private Queue<DatagramPacket> fila;
    private static ThreadRetiraFila retirar;
    private Fila filaa;

    public Fila getFilaa() {
        return filaa;
    }

    public void setFilaa(Fila filaa) {
        this.filaa = filaa;
    }
    
    public Queue<DatagramPacket> getFila() {
        return fila;
    }

    public void setFila(Queue<DatagramPacket> fila) {
        this.fila = fila;
    }

    public ThreadInserirFila(Fila fila, String name) {
        super(name);
        this.filaa = fila;
    }
    
    public void run(){
        if(filaa == null){
            System.out.println("fila é null");
            return;
        }
        while(true){
            inserir();
        }
    }
    public void inserir(){
        try {
            int porta = 2010;
            byte data[] = new byte[1000];
            DatagramSocket soc = new DatagramSocket(porta);
            DatagramPacket pct = new DatagramPacket(data, data.length);
            soc.receive(pct);
            filaa.inserir(pct);
            soc.close();
        } catch (IOException ex) {
            Logger.getLogger(ThreadInserirFila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
