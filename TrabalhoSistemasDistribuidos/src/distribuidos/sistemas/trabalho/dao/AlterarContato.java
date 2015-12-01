package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.classes.TwitterConsumer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo e Johni Andrei Reginatto
 */
public class AlterarContato {
    
    public boolean alterar(Contato objeto) {   
         try {
            String sql  = "UPDATE contato set nome = ?, cep = ?, email = ?, endereco = ?, complemento = ?, emailalternativo = ? WHERE codigo = ?";
            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setInt(7, objeto.getCodigo());
            ps.setString(1, objeto.getNome());
            ps.setInt(2, objeto.getCep().getCep());
            ps.setString(3, objeto.getEmail());
            ps.setString(4, objeto.getEndereco());
            ps.setString(5, objeto.getComplemento());            
            ps.setString(6, objeto.getEmailAlternativo());
            ps.executeUpdate();
            ps.close();
            Conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarContato.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.close();
            return false;
        }
         TwitterConsumer t = new TwitterConsumer();
        t.twittar("O Contato " + objeto.getNome() + " foi adicionado com sucesso!!");
         return true;
    }
}