/*
 * Classe responsavel por retirar o datagrama da fila
 * Percorrer a String do datagrama, estruturando-o conforme a operação
 * para enviar a classe que fará a operação e retornara para o emissor
 */
package receptor.udp;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.AlterarContato;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import distribuidos.sistemas.trabalho.dao.RemoverContato;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
                break;
            }
            retira();
        }
    }
    public void retira(){       
        DatagramPacket pct = fila.peek(); // Pego da fila, mas nao removo
        String msg = new String(pct.getData());
        //processa
        System.out.println("Mensagem "+msg);// So pra teste
        msg = new String(fila.poll().getData()); // Retiro o datagrama da fila e guardo ele inteiro em uma string
        
        msg = "d/3";
        
        System.out.println("Retiro o datagrama da fila e guardo ele inteiro em uma string");
        String dado = new String(); // Instancio uma String para ir concatenando os caracteres
        for(int i=0; i<msg.length(); i++){ // Percorre a string inteira
            char c = msg.charAt(i); // Jogo cada caracter da string em uma variavel caracter
            if(c!='/') // Se for diferente de /
                dado += c; // Concatena
            else{ // Se for igual a /(significa que ta separando o dado)
                dados.add(dado); //  Joga a String concatenada em uma lista(é um dado inteiro)
                dado = ""; // "Esvazia" a string para começar a concatenar denovo
            } 
        }
        dados.add(dado);
        
//        System.out.println("1 - "+dados.get(0));
//        System.out.println("2 - "+dados.get(1));
//        System.out.println("3 - "+dados.get(2));
//        System.out.println("4 - "+dados.get(3));
        
        
        for(int i=0; i<dados.size(); i++){ // Percore a lista
            if(dados.get(i).equals("a")){
                Inserir ic = new Inserir();
                String resposta = "";
                if(ic.inserir(dados)){
                    resposta = "ok";
                }else{
                    resposta = "er";
                }
                RetornarCliente rc = new RetornarCliente();
                try {
                    rc.responder(pct.getAddress(), resposta);
                } catch (Exception ex) {
                    Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
            if(dados.get(i).equals("m")){
                Alterar ic = new Alterar();
                String resposta = "";
                if(ic.alterar(dados)){
                    resposta = "Alterado com sucesso!";
                }else{
                    resposta = "Falha ao alterar, por favor tente novamente!";
                }
                RetornarCliente rc = new RetornarCliente();
                try {
                    rc.responder(pct.getAddress(), resposta);
                } catch (Exception ex) {
                    Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(dados.get(i).equals("d")){
                Deletar ic = new Deletar();
                String resposta = "";
                if(ic.deletar(dados)){
                    resposta = "Deletado com sucesso!";
                }else{
                    resposta = "Falha ao deletar, por favor tente novamente!";
                }
                RetornarCliente rc = new RetornarCliente();
                try {
                    rc.responder(pct.getAddress(), resposta);
                } catch (Exception ex) {
                    Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            // PRECISO VER O RETORNO PARA O CLIENTE
            if(dados.get(i).equals("c")){ // Testa se for cansultar e guarda o código recebido
                Consultar ic = new Consultar();
                String resposta = "";
                Contato contato = new Contato();
                try {
                    contato = ic.consultar(dados);
                    resposta = contato.getCodigo()+" "+contato.getNome()+" "+contato.getEmail()+" "+contato.getEndereco()+
                               " "+ contato.getComplemento()+" "+contato.getEmailAlternativo();
                    RetornarCliente rc = new RetornarCliente();
                    rc.responder(pct.getAddress(), resposta);
                    System.out.println("Resposta para cliente : "+resposta);
                } catch (Exception ex) {
                    Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(dados.get(i).equals("l")){ // Testa se for listar e guarda a cidade a qual deseja rceeber os contatos.
                List<String> lista = new ArrayList<>();
                Listar listar = new Listar();
                RetornarCliente rc = new RetornarCliente();
                try {
                    lista = listar.listar(dados);
                    rc.responder(pct.getAddress(), lista);
                } catch (Exception ex) {
                    Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
