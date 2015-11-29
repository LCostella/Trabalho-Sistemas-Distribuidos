/*
 * Classe responsavel por retirar o datagrama da fila
 * Percorrer a String do datagrama, estruturando-o conforme a operação
 * para enviar a classe que fará a operação e retornara para o emissor
 */
package receptor.udp;

import distribuidos.sistemas.trabalho.classes.Contato;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ThreadRetiraFila extends Thread{
    private Queue<DatagramPacket> fila;
    private List<String> dados = new ArrayList<>();
    private Contato contato = new Contato();
    private Fila filaa;

    public Fila getFilaa() {
        return filaa;
    }

    public void setFilaa(Fila filaa) {
        this.filaa = filaa;
    }

    public Queue<DatagramPacket> getFila() {
        return fila;
    }

    public void setFila(Queue<DatagramPacket> fila) {
        this.fila = fila;
    }

    public ThreadRetiraFila(Fila fila, String name) {
        super(name);
        this.filaa = fila;
    }
    
    public void run(){
        if(filaa == null){
            System.out.println("fila é null");
            return;
        }
        //escuta a porta e retira na fila
        while(true){
            DatagramPacket pct = filaa.retirar();
            if(pct != null){
                retira(pct);
            }            
        }
    }
    public void retira(DatagramPacket pct){       

        String msg = new String(pct.getData());
        System.out.println("retirou da fila");
        String dado = new String(); // Instancio uma String para ir concatenando os caracteres
        for(int i=0; i<msg.length(); i++){ 
            char c = msg.charAt(i); 
            if(c!='/') 
                dado += c; 
            else{ // Se for igual a /(significa que ta separando o dado)
                dados.add(dado); 
                dado = ""; // "Esvazia" a string para começar a concatenar denovo
            } 
        }
        dados.add(dado);

        if(dados.get(0).equals("a")){
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

        if(dados.get(0).equals("m")){
            Alterar ic = new Alterar();
            String resposta = "";
            if(ic.alterar(dados)){
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

        if(dados.get(0).equals("d")){
            Deletar ic = new Deletar();
            String resposta = "";
            if(ic.deletar(dados)){
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

        // PRECISO VER O RETORNO PARA O CLIENTE
        if(dados.get(0).equals("c")){ // Testa se for cansultar e guarda o código recebido
            Consultar ic = new Consultar();
            String resposta = "";
            Contato contato = new Contato();
            try {
                contato = ic.consultar(dados);
                resposta = contato.getCodigo()+" "+contato.getNome()+" "+contato.getEmail()+" "+contato.getEndereco()+
                           " "+ contato.getComplemento()+" "+contato.getEmailAlternativo();
                System.out.println("Resposta para cliente : "+resposta);
                RetornarCliente rc = new RetornarCliente();
                rc.responder(pct.getAddress(), resposta);
            } catch (Exception ex) {
                Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(dados.get(0).equals("l")){ // Testa se for listar e guarda a cidade a qual deseja rceeber os contatos.
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
