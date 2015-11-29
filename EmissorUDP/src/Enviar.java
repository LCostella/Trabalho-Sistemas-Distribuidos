
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manoela
 */
public class Enviar {
    public void envia(String msg) throws Exception {
        int porta = 2010;
        String host = new String("localhost");
        byte data[] = new byte[1000];
        data = msg.getBytes();
        InetAddress address = InetAddress.getByName(host);
        DatagramSocket soc = new DatagramSocket();
        DatagramPacket pct = new DatagramPacket(data, data.length, address, porta);

        soc.send(pct);
        soc.close();
        
    }
    
}
