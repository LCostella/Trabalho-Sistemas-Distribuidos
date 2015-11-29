/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientetcp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matheus
 */
public class ClienteTCP {

    
    public static void main(String args[]) throws Exception{
      
       
        char op;
        
        
        do{  
          
            System.out.println("\n\nMENU:");
            System.out.println("Adicionar (add) - a");
            System.out.println("Alterar (modify) - m");
            System.out.println("Excluir (delete) - d");
            System.out.println("Consultar (consult) - c");
            System.out.println("Listar Cidades (list) - l");
       
            System.out.println("\nEscolha uma das opções acima:");
            Scanner s= new Scanner(System.in);
            op = s.next().charAt(0);
            
                if(op=='a'){
                    System.out.println("Você escolheu a opcao Adicionar. ");
                    Inserir a = new Inserir();
                    a.inserir();
                }
                if(op=='m'){
                    System.out.println("Você escolheu a opcao Alterar.");
                    Alterar m = new Alterar();
                    m.altera();
                }
                if(op=='d'){
                    System.out.println("Você escolheu a opcao Excluir.");
                    Deletar d = new Deletar();
                    d.delete();
                }
                if(op=='c'){
                    System.out.println("Você escolheu a opcao Consultar.");
                    Consultar c = new Consultar();
                    c.consult();
  
                }
                if(op=='l'){
                    System.out.println("Você escolheu a opcao Listar Cidade.");
                    Listar l = new Listar();
                    l.list();
                }
                if(op=='s'){
                    System.out.println("Saindo..");
                }
                if(op!='a'&&op!='m'&&op!='d'&&op!='c'&&op!='l'&&op!='s'){
                    System.out.println("Operação invalida, digite uma operação valida");   
                }
            
        
        }while(op != 's');
    
    }
}
