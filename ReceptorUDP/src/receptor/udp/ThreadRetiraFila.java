/*
 * Classe responsavel por retirar o datagrama da fila
 * Percorrer a String do datagrama, estruturando-o conforme a operação
 * para enviar a classe que fará a operação e retornara para o emissor
 */
package receptor.udp;

import distribuidos.sistemas.trabalho.classes.Contato;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Felipe
 */
public class ThreadRetiraFila extends Thread{
    private Queue<DatagramPacket> fila;
    List<String> dados = new ArrayList<>();
    Contato contato = new Contato();

    public Queue<DatagramPacket> getFila() {
        return fila;
    }

    public void setFila(Queue<DatagramPacket> fila) {
        this.fila = fila;
    }

    public ThreadRetiraFila(Queue<DatagramPacket> fila, String name) {
        super(name);
        this.fila = fila;
    }
    
    public void run(){
        if(fila == null){
            System.out.println("fila é null");
            return;
        }
        //escuta a porta e retira na fila
        while(true){
            if(fila.isEmpty()){
                continue;
            }
            retira();
        }
    }
    public void retira(){       
        DatagramPacket pct = fila.poll();
        String msg = new String(pct.getData());
        //processa
        
        msg = new String(fila.poll().getData()); // Retiro o datagrama da fila e guardo ele inteiro em uma string
        
        String dado = new String(); // Instancio uma String para ir concatenando os caracteres
        for(int i=0; i<msg.length(); i++){ // Percorre a string inteira
            char c = msg.charAt(i); // Jogo cada caracter da string em uma variavel caracter
            if(c!='/') // Se for diferente de /
                dado = dado + c; // Concatena
            else{ // Se for igual a /(significa que ta separando o dado)
                dados.add(dado); //  Joga a String concatenada em uma lista(é um dado inteiro)
                dado = ""; // "Esvazia" a string para começar a concatenar denovo
            } 
        }
        //"codigo/nome/email/endereco/complemento/cep/cidade/estado/email alternativo
        for(int i=0; i<dados.size(); i++){ // Percore a lista
            if(dados.get(i)=="a"){ // Testa se for adição, se for, popula o objeto com os dados proximos da lista
                i++;
                contato.setCodigo((Integer.getInteger(dados.get(i))));
                i++;
                contato.setNome(dados.get(i));
                i++;
                contato.setEmail(dados.get(i));
                i++;
                contato.setEndereco(dados.get(i));
                i++;
                contato.setComplemento(dados.get(i));
                i++;
                //contato.setCep(dados.get(i));
                //i++;
                //contato.set();
                //i++;
                //contato.set();
                //i++;
                //contato.setEmailAlternativo(dados.get(i));
                //i++;
            }
        }
    }
    
    
}
