
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
            soc.setSoTimeout(60000); //60 segundos
            soc.receive(pct);
            msg = new String(pct.getData());
            System.out.println("Resposta: " + msg);

            if (msg.equals("inicio")) { // testando se a resposta é uma lista (SE FOR VAI MOSTRAR AQUI MESMO)
                while (!msg.equals("fim")) { // para todas as mensagens até a última:
                    soc.receive(pct); //recebe...
                    msg = new String(pct.getData()); //...pega o conteúdo...
                    System.out.println(msg); //...mostra o conteúdo.
                }
            }
        } catch (SocketTimeoutException time) {
            System.out.println("Tempo máximo de espera atingido!");
            return "er";
        } catch(Exception e){
            System.out.println("Erro no recebimento da resposta!");
            return "er";
        }

        soc.close();
        return msg;
    }

}
