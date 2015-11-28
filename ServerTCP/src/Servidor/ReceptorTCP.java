/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Emanoel
 */
public class ReceptorTCP {
     
    public ReceptorTCP() {
        
    }
    public static void main(String[] args) throws IOException {
       
        int porta = 2006;
        
        ServerSocket servidor;
        //System.out.println("ServerSocket criado com sucesso na porta " + servidor.getLocalPort());
        servidor = new ServerSocket(porta);
        
         do{
             
            //Fica esperando uma conexão TPC nova no socket do servidor
            Socket client = servidor.accept();
                System.out.println("Conexão iniciada com o cliente "
                        + client.getInetAddress().getHostAddress() + ":" + client.getPort());
                //assim que consegue, cria e inicia uma thread para tomar conta do processameto que se conectou
            
                ThreadProcessamento tc = new ThreadProcessamento(client, client.getInputStream(), client.getOutputStream());
                new Thread(tc).start();
        }while(true);

           
    }
    
}
