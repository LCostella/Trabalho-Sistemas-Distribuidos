/*
 * Classe que vai ficar escutando a porta, e ira inserir na fila o datagrama recebido.
 */
package receptor.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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

    public Queue<DatagramPacket> getFila() {
        return fila;
    }

    public void setFila(Queue<DatagramPacket> fila) {
        this.fila = fila;
    }

    public ThreadInserirFila(Queue<DatagramPacket> fila, String name) {
        super(name);
        this.fila = fila;
    }
    
    public synchronized void run(){
        if(fila == null){
            System.out.println("fila é null");
            return;
        }
        //escuta a porta e insere na fila
        while(fila.isEmpty()){
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
            soc.receive(pct);
            System.out.println("Aguarda mensagem");
            fila.add(pct);// recebeu e insere na fila
            System.out.println("Recebeu mensagem");
            soc.close(); // precisa verificar se pode dar close
            retirar = new ThreadRetiraFila(fila, "retirar");
            retirar.start();
        //} catch (SocketException ex) {
        //    Logger.getLogger(ThreadInserirFila.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadInserirFila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
