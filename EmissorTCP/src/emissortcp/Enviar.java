/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emissortcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class Enviar {
    public static void envia(List msg) throws Exception{
        // TODO code application logic here
        String host = new String("localhost");
        int porta   = 2006;
        System.out.println("Cliente");
        Socket soc = new Socket(host, porta);
        
        ObjectOutputStream objgrava = new ObjectOutputStream(soc.getOutputStream());
        ObjectInputStream  objle    = new ObjectInputStream(soc.getInputStream());
        objgrava.writeObject(msg);
  

        msg = (List) objle.readObject();
        System.out.println("Voltou do Servidor " + msg);
        objgrava.flush();
        soc.close();
        
    }
}
