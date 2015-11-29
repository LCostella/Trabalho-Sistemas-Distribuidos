/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptor.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

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
        System.out.println("Respondendo: "+ msg);
        int porta = 2010;
        byte data[] = new byte[1000];//verificar se tem que mudar no cliente
        data = msg.getBytes();
        DatagramSocket soc = new DatagramSocket();
        DatagramPacket pac = new DatagramPacket(data, data.length, endereco, porta);
        soc.send(pac);
        soc.close();
    }
    
    /**
    * @param endereco  endereco de ip do receptor
    * @param lista lista de mensagens
    */
    public void responder(InetAddress endereco, List<String> lista) throws Exception{
        responder(endereco, "inicio");
        for(String s : lista){
            responder(endereco, s);
        }
        responder(endereco, "fim");

    }
}
