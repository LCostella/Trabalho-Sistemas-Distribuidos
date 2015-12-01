package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.classes.TwitterConsumer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class RemoverContato {
    public boolean remover(Contato objeto) {
        try {
            String sql = "DELETE FROM contato where codigo=?";
            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            ps.close();
            Conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(RemoverContato.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.close();
            return false;
        }
        TwitterConsumer t = new TwitterConsumer();
        t.twittar("O Contato " + objeto.getNome() + " foi removido com sucesso!!");
        return true;
    }
}
