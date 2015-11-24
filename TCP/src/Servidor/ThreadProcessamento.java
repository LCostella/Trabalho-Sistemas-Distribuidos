/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import distribuidos.sistemas.trabalho.classes.Contato;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanoel
 */
public class ThreadProcessamento extends Thread {
    Socket client;
    ObjectInputStream clientInput;
    ObjectOutputStream clientOutput;
    Contato contato = new Contato();
    
    
    List<String> dados = new ArrayList<>();

    ThreadProcessamento(Socket client, InputStream clientInput, OutputStream clientOutput) throws IOException {
        this.client = client;
        this.clientInput =  new ObjectInputStream(client.getInputStream());
        this.clientOutput = new ObjectOutputStream(client.getOutputStream());
    }
    
    @Override
     public void run() {
        
        try {
            
            String tipo2= "emanoel";
            
            try {           
                dados = (List<String>) clientInput.readObject();
                for(int i=0; i<dados.size(); i++){ // Percore a lista
                    if(dados.get(0).equals("a")){
                        String resposta = "";
                        if(dados.get(i).equals("a")){
                            Inserir ic = new Inserir();
                           
                            if(ic.inserir(dados)){
                                resposta = "ok";
                            }else{
                                resposta = "er";
                            }                           
                        }
                        System.out.println(dados);

                        System.out.println("Inserir " + resposta);
                        clientOutput.writeObject(resposta);
                    }
                    if(dados.get(0).equals("m")){
                       Alterar ic = new Alterar();
                       String resposta = "";
                       if(ic.alterar(dados)){
                           resposta = "Alterado com sucesso!";
                       }else{
                           resposta = "Falha ao alterar, por favor tente novamente!";
                       }
                        System.out.println(dados);

                        System.out.println("Deletar " + resposta);
                        clientOutput.writeObject(resposta);
                    }
                     
                    if(dados.get(0).equals("d")){
                        Deletar ic = new Deletar();
                        String resposta = "";
                        if(ic.deletar(dados)){
                            resposta = "Deletado com sucesso!";
                      
                        }else{
                            resposta = "Falha ao deletar, por favor tente novamente!";
                        }
                        
                        System.out.println(dados);

                        System.out.println("Deletar " + resposta);
                        clientOutput.writeObject(resposta);
                    }
                    if(dados.get(0).equals("c")){
                        Consultar ic = new Consultar();
                        String resposta = "";
                        Contato contato = new Contato();
                       
                        try {
                            contato = ic.consultar(dados);
                             resposta = contato.getCodigo()+" "+contato.getNome()+" "+contato.getEmail()+" "+contato.getEndereco()+
                                    " "+ contato.getComplemento()+" "+contato.getEmailAlternativo();
                        } catch (Exception ex) {
                            Logger.getLogger(ThreadProcessamento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                       
         
                        System.out.println(dados);

                        
                        System.out.println("Consultar " + resposta);
                        clientOutput.writeObject(resposta);
                    }
                    if(dados.get(0).equals("l")){
                        List<String> lista = new ArrayList<>();
                        Listar listar = new Listar();
                        
                        try {
                            lista = listar.listar(dados);
                          
                        } catch (Exception ex) {
                            Logger.getLogger(ThreadProcessamento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        System.out.println(dados);

                        
                        System.out.println("Consultar " + lista);
                        clientOutput.writeObject(lista);
                    }
                }
                
            }catch (IOException ex) {
                Logger.getLogger(ThreadProcessamento.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadProcessamento.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
         
}
    

