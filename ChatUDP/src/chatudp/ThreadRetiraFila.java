package chatudp;


import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johni
 */
public class ThreadRetiraFila extends Thread{
    private Queue<DatagramPacket> fila;
    private List<String> dados = new ArrayList<>();
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

    public ThreadRetiraFila(Fila fila, String name) {
        super(name);
        this.filaa = fila;
    }
    
    public void run(){
        if(filaa == null){
            System.out.println("fila é null");
            return;
        }
        //escuta a porta e retira na fila
        while(true){
            DatagramPacket pct = filaa.retirar();
            if(pct != null){
                try {
                    retira(pct);
                } catch (Exception ex) {
                    Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
    }
    public void retira(DatagramPacket pct) throws Exception{       
        String msg = new String(pct.getData());
        System.out.println(pct.getAddress()+" diz: "+msg);
        
    }
}
