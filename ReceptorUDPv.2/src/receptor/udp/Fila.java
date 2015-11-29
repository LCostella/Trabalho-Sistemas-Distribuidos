/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptor.udp;

import java.net.DatagramPacket;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author felipe
 */
public class Fila {
   public Queue<DatagramPacket> fila;  // definindo um HashMap (MAPA) para armazenar os valores do contador  

   
   public Fila(){
       fila = new LinkedList<>();
   }
   //public int contador(){   // Sem Sincronismo  
   public synchronized DatagramPacket retirar() { // Com Sincronismo  **método que incrementa o contador e verifica se valor do contador já foi adicionado no HasMap**  
         if(fila.isEmpty()){
             return null;
         }else{
             return fila.poll();
         } 
   } 
   public synchronized void inserir(DatagramPacket pct) { // Com Sincronismo  **método que incrementa o contador e verifica se valor do contador já foi adicionado no HasMap**  
         if(pct!= null){
             fila.add(pct);
         }
   }

}
