package chatudp;


import java.net.DatagramPacket;
import java.net.InetAddress;
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
public class ThreadResponde extends Thread{
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

    public ThreadResponde(Fila fila, String name) {
        super(name);
        this.filaa = fila;
    }
    
    public void run(){
        while(true){
                try {
                    responde();
                } catch (Exception ex) {
                    Logger.getLogger(ThreadResponde.class.getName()).log(Level.SEVERE, null, ex);
                }         
    }
    }
    public void responde() throws Exception{       
        Scanner entrada = new Scanner(System.in);
        String msg = new String(entrada.nextLine());
        String host = new String("192.168.2.18");
        InetAddress address = InetAddress.getByName(host);
        RetornarCliente rc = new RetornarCliente();
        rc.responder(address,msg);
        
    }
}
