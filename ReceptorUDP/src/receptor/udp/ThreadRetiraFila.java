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
        //lembre de que quando for add nao tem codigo
        //"codigo/nome/email/endereco/complemento/cep/cidade/estado/email alternativo
        //"Adicionar (add) --------> a");
        //"Alterar (modify) -------> m");
        //"Excluir (delete) -------> d");
        //"Consultar (consult) ----> c");
        //"Listar Cidades (list) --> l");
           
        //johni.... usar isso como exemplo para os demais
        if(dados.get(0).equals("a")){
            Inserir ic = new Inserir();
            String resposta = "";
            if(ic.inserir(dados)){
                resposta = "Inserido com sucesso!";
            }else{
                resposta = "Falha ao inserir, por favor tente novamente!";
            }
            RetornarCliente rc = new RetornarCliente();
            try {
                rc.responder(pct.getAddress(), resposta);
            } catch (Exception ex) {
                Logger.getLogger(ThreadRetiraFila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // fim exemplo
        
        
        
        
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
//                InserirContato ic = new InserirContato();
//                if(ic.inserir(contato)){
//                    System.out.println("Cadastrado com sucesso!");
//                    // Aqui vamos retornar para o cliente
//                }
            }
            if(dados.get(i)=="m"){ // Testa se for alterar, se for popula o objeto com os dados proximos da lista
                i++;
                
                AlterarContato ac = new AlterarContato();
                if(ac.alterar(contato)){
                    System.out.println("Alterado com sucesso!");
                }
            }
            
            if(dados.get(i)=="d"){ // Testa se for deletar, e recebe o codigo a ser deletado
                i++;
                int cod = Integer.getInteger(dados.get(i));
                i++;
                
                RemoverContato ic = new RemoverContato();
                if(ic.remover(contato)){
                    System.out.println("Excluido com sucesso!");
                    return;
                }else{
                    System.out.println("Erro ao excluir");
                    return;
                }
            }
            
            if(dados.get(i)=="c"){ // Testa se for cansultar e guarda o código recebido
                i++;
                int codigo = Integer.getInteger(dados.get(i));
                i++;

                BuscarContato bc = new BuscarContato();
                contato = null;
                try {
                    contato = bc.buscarContato(codigo);
                } catch (SQLException ex) {
                    System.out.println("Erro: "+
                        ex.getLocalizedMessage());
                }
            }
            
            if(dados.get(i)=="l"){ // Testa se for listar e guarda a cidade a qual deseja rceeber os contatos.
                i++;
                String cidade = dados.get(i);
                i++;  
            }
        }
    }
    
    
}
