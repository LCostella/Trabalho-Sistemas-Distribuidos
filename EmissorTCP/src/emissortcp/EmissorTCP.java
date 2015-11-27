/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emissortcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import emissortcp.Adicionar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.util.Scanner;

/**
 *
 * @author Matheus
 */
public class EmissorTCP {

    
    public static void main(String args[]) throws Exception{
        char op = 'o';
        
        System.out.println("EMISSOR TCP");
        System.out.println("Selecione a opção desejada:");
        System.out.println("Adicionar (add) - a");
        System.out.println("Alterar (modify) - m");
        System.out.println("Excluir (delete) - d");
        System.out.println("Consultar (consult) - c");
        System.out.println("Listar Cidades (list) - l");
        
        
        do{  
            Scanner s= new Scanner(System.in);
            op = s.next().charAt(0);
            switch (op){
                case 'a': //ADD
                    System.out.println("Você escolheu a opcao Adicionar.");
                    Adicionar.add();
                    break;
                case 'm': //MODIFY
                    System.out.println("Você escolheu a opcao Alterar.");
                    Modificar.modify();
                    break;
                case 'd': //DELETE
                    System.out.println("Você escolheu a opcao Excluir.");
                    Deletar.delete();
                    break;
                case 'c': //CONSULT
                    System.out.println("Você escolheu a opcao Consultar.");
                    Consultar.consult();
                    break;
                case 'l': //LIST
                    System.out.println("Você escolheu a opcao Listar Cidade.");
                    Listar.list();
                    break;
            }
        
        }while(op == 's');
    }


    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) throws Exception {
        // TODO code application logic here
        menu();
    }*/
    
}
