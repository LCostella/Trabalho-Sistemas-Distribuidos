

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manoela
 */
public class Emissor {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        try {
            Receber r = new Receber();
            r.receber();
        } catch (Exception ex) {
            Logger.getLogger(Emissor.class.getName()).log(Level.SEVERE, null, ex);
        }
        char op = 'o';
        Scanner entrada = new Scanner(System.in);
        
        
                
        do {
            try {
                System.out.println("-------- EMISSOR UDP ---------");
                System.out.println(" ");
                System.out.println("Selecione a opção desejada:");
                System.out.println(" ");
                System.out.println("Adicionar (add) -----------> a");
                System.out.println("Alterar (modify) ----------> m");
                System.out.println("Excluir (delete) ----------> d");
                System.out.println("Consultar (consult) -------> c");
                System.out.println("Listar por Cidade (list) --> l");
                System.out.println("Listar por Codigo (list) --> o");
                System.out.println("SAIR (exit) ---------------> e");
                
                op = entrada.next().charAt(0);
                switch (op) {
                    case 'a': //ADD
                        System.out.println("Você escolheu a opcao Adicionar.");
                        Adicionar a = new Adicionar();
                        a.add();  
                        
                        Receber ra = new Receber();
                        String respostaa = ra.receber();
                        
                        if (respostaa.equals("ok")) 
                        {
                            System.out.println("Dados cadastrados com sucesso!");
                        } else if (respostaa.equals("er")) {
                            System.out.println("Erro: repita o procedimento.");
                        }                            
                        break;
                    case 'm': //MODIFY
                        System.out.println("Você escolheu a opcao Alterar.");
                        Modificar m = new Modificar();
                        m.modify();
                        
                        Receber rm = new Receber();
                        String respostam = rm.receber();
                        
                        if (respostam.equals("ne"))//verificar se o cadastro existe (ne = não existe)
                        {
                            System.out.println("Cadastro não existente!");
                        } else if (respostam.equals("ok")) {
                            System.out.println("Cadastro alterado com sucesso!");//receber uma resposta para dar o ok para o usuário
                        } else if (respostam.equals("er")) {
                            System.out.println("Erro: repita o procedimento.");
                        }
                        
                        break;
                    case 'd': //DELETE
                        System.out.println("Você escolheu a opcao Excluir.");
                        Deletar d = new Deletar();
                        d.delete();
                        
                        Receber rd = new Receber();
                        String respostad = rd.receber();
                        
                        if (respostad.equals("ne"))//verificar se o cadastro existe
                        {
                            System.out.println("Cadastro não existente!");
                        } else if (respostad.equals("ok")) {
                            System.out.println("Cadastro excluido com sucesso!");//receber uma resposta para dar o ok para o usuário
                        } else if (respostad.equals("er")) {
                            System.out.println("Erro: repita o procedimento.");
                        }
                        break;
                    case 'c': //CONSULT
                        System.out.println("Você escolheu a opcao Consultar.");
                        Consultar c = new Consultar();
                        c.consult();
                        
                        Receber rc = new Receber();
                        String respostac = rc.receber();
                        
                        if (respostac.equals("ne"))//verificar se o cadastro existe
                        {
                            System.out.println("Cadastro não existente!");
                        } else if (respostac.equals("er")) {
                            System.out.println("Erro: repita o procedimento.");
                        } else {
                            System.out.println("Resultado da pesquisa: " + respostac);
                        }
                        break;
                    case 'l': //LIST
                        System.out.println("Você escolheu a opcao Listar Cidade.");
                        ListarCidade l = new ListarCidade();
                        l.list();
                        
                        Receber rl = new Receber();
                        String respostal = rl.receber();
                        
                        if (respostal.equals("ne"))//verificar se o cadastro existe
                        {
                            System.out.println("Cadastro não existente!");
                        } else if (respostal.equals("er")) {
                            System.out.println("Erro: repita o procedimento.");
                        } else {
                            System.out.println("Mostrando resultado da pesquisa: " + respostal);
                        }
                        break;
                    case 'o': //OTHER LIST
                        System.out.println("Você escolheu a opcao Listar Cidade.");
                        ListarCodigo lc = new ListarCodigo();
                        lc.listcod();
                        
                        Receber rlc = new Receber();
                        String respostalc = rlc.receber();
                        
                        if (respostalc.equals("ne"))//verificar se o cadastro existe
                        {
                            System.out.println("Cadastro não existente!");
                        } else if (respostalc.equals("er")) {
                            System.out.println("Erro: repita o procedimento.");
                        } else {
                            System.out.println("Mostrando resultado da pesquisa: " + respostalc);
                        }
                        break;
                    case 'e': //EXIT
                        System.out.println("Você escolheu a opção sair.");
                        break;
                    default:
                        System.out.println("Valor inválido!");
                        break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Emissor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } while (op != 'e');
        
    }

    
    

    

    

    

    

    

    

}
