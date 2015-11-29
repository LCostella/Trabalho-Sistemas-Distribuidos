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
public class Alterar {
    List<String> dados = new ArrayList<>();
    public void altera() throws Exception {
        dados.add("m");
        
        Scanner entradac = new Scanner(System.in);
        String codigo = new String();
        System.out.println("Código:");
        codigo = entradac.next(); //guardar resultado na variável 'adiciona'
        dados.add(codigo);
        
        System.out.println("Nome:");
        Scanner entradan = new Scanner(System.in);
        String nome = new String();
        nome = entradan.next();
        dados.add(nome);
        
        System.out.println("E-mail:");
        Scanner entradae = new Scanner(System.in);
        String email = new String();
        email = entradae.next();
        dados.add(email);
        
        System.out.println("Endereço:");
        Scanner entradaend = new Scanner(System.in);
        String endereco = new String();
        endereco = entradaend.next();
        dados.add(endereco);
        
        System.out.println("Complemento:");
        Scanner entradacom = new Scanner(System.in);
        String complemento = new String();
        complemento = entradacom.next();
        dados.add(complemento);
        
        System.out.println("CEP:");
        Scanner entradacep = new Scanner(System.in);
        String cep = new String();
        cep = entradacep.next();
        dados.add(cep);
        
        System.out.println("Cidade:");
        Scanner entradaci = new Scanner(System.in);
        String cidade = new String();
        cidade = entradaci.next();
        dados.add(cidade);
        
        System.out.println("Estado:");
        Scanner entradaes = new Scanner(System.in);
        String estado = new String();
        estado = entradaes.next();
        dados.add(estado);
        
        System.out.println("E-mail alternativo:");
        Scanner entradaea = new Scanner(System.in);
        String alternativo = new String();
        alternativo = entradaea.next();
        dados.add(alternativo);
        
        EnviarRecebe e = new EnviarRecebe();
        e.envia(dados);
      

    }
}
