/*
 * Classe responsavel por retirar o datagrama da fila
 * Percorrer a String do datagrama, estruturando-o conforme a operação
 * para enviar a classe que fará a operação e retornara para o emissor
 */
package receptor.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Queue;

/**
 *
 * @author Felipe
 */
public class ThreadRetiraFila extends Thread{
    private Queue<DatagramPacket> fila;

    public Queue<DatagramPacket> getFila() {
        return fila;
    }

    public void setFila(Queue<DatagramPacket> fila) {
        this.fila = fila;
    }

    public ThreadRetiraFila(Queue<DatagramPacket> fila, String name) {
        super(name);
        this.fila = fila;
    }
    
    public void run(){
        if(fila == null){
            System.out.println("fila é null");
            return;
        }
        //escuta a porta e insere na fila
        while(true){
            if(fila.isEmpty()){
                continue;
            }
            retira();
        }
    }
    public void retira(){       
        DatagramPacket pct = fila.poll();
        String msg = new String(pct.getData());
        //processa
    }
    
    
}
