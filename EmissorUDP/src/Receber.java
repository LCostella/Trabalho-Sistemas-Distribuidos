
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manoela
 */
public class Receber {

    public String receber() throws Exception {
        try {
            int porta = 2010;
            byte data[] = new byte[1000];
            DatagramSocket soc = new DatagramSocket(porta);
            DatagramPacket pct = new DatagramPacket(data, data.length);
            String msg;
            
            System.out.println("Aguardando mensagem... (tempo máximo de espera 1 minuto)");
            soc.setSoTimeout(600);
            soc.receive(pct);
            msg = new String(pct.getData());
            
            if (msg.equals("inicio")) { // testando se a resposta é uma lista (SE FOR VAI MOSTRAR AQUI MESMO)
                while (!msg.equals("fim")) { // para todas as mensagens até a última:
                    soc.receive(pct); //recebe...
                    msg = new String(pct.getData()); //...pega o conteúdo...
                    System.out.println(msg); //...mostra o conteúdo.
                }
            }else{
                System.out.println("Resposta: " + msg);
            }
            
            soc.close();
            return msg;
        } catch (SocketTimeoutException ex) {
            System.out.println("Tempo expirado");
        }
        return "er";
    }

}
