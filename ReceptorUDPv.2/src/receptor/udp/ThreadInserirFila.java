/*
 * Classe que vai ficar escutando a porta, e ira inserir na fila o datagrama recebido.
 */
package receptor.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
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
        //escuta a porta e insere na fila
        while(true){
            inserir();
        }
    }
    public void inserir(){
        try {
            int porta = 2010;
            byte data[] = new byte[1000];
            System.out.println("Instanciou Socket");
            DatagramSocket soc = new DatagramSocket(porta); // Instancia um DatagramSocket
            DatagramPacket pct = new DatagramPacket(data, data.length); // Instancia um DatagramPacket
            System.out.println("Aguarda mensagem");
            soc.receive(pct);
            filaa.inserir(pct);// recebeu e insere na fila
            System.out.println("Recebeu mensagem");
            soc.close(); // precisa verificar se pode dar close
            //retirar = new ThreadRetiraFila(fila, "retirar");
            //retirar.start();
        } catch (IOException ex) {
            Logger.getLogger(ThreadInserirFila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
