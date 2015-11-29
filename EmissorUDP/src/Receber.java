
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
        
        int porta = 2010;
        byte data[] = new byte[1000];
        DatagramSocket soc = new DatagramSocket(porta);
        DatagramPacket pct = new DatagramPacket(data, data.length);
        String msg;
        try {   
            System.out.println("Aguardando mensagem... (tempo máximo de espera 1 minuto)");
            soc.setSoTimeout(600000);
            soc.receive(pct);
            msg = new String(pct.getData());
            
            if (msg.trim().equals("inicio")) { // testando se a resposta é uma lista (SE FOR VAI MOSTRAR AQUI MESMO)
                while (true) { // para todas as mensagens até a última:
                    data = new byte[1000];
                    pct = new DatagramPacket(data, data.length);
                    soc.receive(pct); //recebe...
                    msg = new String(pct.getData()); //...pega o conteúdo...
                    if(msg.trim().equals("fim")){
                        break;
                    }
                    System.out.println(msg); //...mostra o conteúdo.
                }
            }else{
                System.out.println("Resposta: " + msg);
            }
            
          
        } catch (SocketTimeoutException ex) {
            msg = "er";
            System.out.println("Tempo expirado");
        }
        soc.close();
        return msg;
    }

}
