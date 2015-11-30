package chatudp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

/**
 *
 * @author Johni
 */
public class RetornarCliente {
    
    /**
    * @param endereco  endereco de ip do receptor
    * @param msg mensagem
    */
    public void responder(InetAddress endereco, String msg) throws Exception{
        int porta = 2010;
        byte data[] = new byte[1000];
        data = msg.getBytes();
        DatagramSocket soc = new DatagramSocket(2001);
        DatagramPacket pac = new DatagramPacket(data, data.length, endereco, porta);
        soc.send(pac);
        soc.close();
    }
}
