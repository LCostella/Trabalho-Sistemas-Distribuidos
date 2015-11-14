/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptor.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author felipe
 */
public class RetornarCliente {
    
    /**
    * @param endereco  endereco de ip do receptor
    * @param msg mensagem
    */
    public void responder(InetAddress endereco, String msg) throws Exception{
        int porta = 2010;
        byte data[] = new byte[100];
        data = msg.getBytes();
        DatagramSocket soc = new DatagramSocket(porta);
        DatagramPacket pac = new DatagramPacket(data, data.length, endereco, porta);
        soc.send(pac);
        soc.close();
    }
}
