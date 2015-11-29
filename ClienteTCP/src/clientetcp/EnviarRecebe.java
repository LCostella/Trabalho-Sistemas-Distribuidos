/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientetcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Emanoel
 */
public class EnviarRecebe {
    public static void envia(List<String> msg) throws Exception{
        // TODO code application logic 
        
        String host = new String("localhost");
        // para buscar no servidor que se encontra neste pc 
       
        int porta   = 2006;
        
       
        
        Socket soc = new Socket(host, porta);
        
        ObjectOutputStream objgrava = new ObjectOutputStream(soc.getOutputStream());
        
        objgrava.writeObject(msg);
        
        
        ObjectInputStream obj = new ObjectInputStream(soc.getInputStream());
        String resposta = "";
        resposta = (String) obj.readObject();
       
         System.out.println(resposta);
    }
     

    
    
}
