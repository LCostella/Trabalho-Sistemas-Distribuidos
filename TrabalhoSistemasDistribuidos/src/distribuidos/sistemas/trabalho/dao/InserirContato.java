package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.classes.Twitter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliardo Marini
 * Refatorado por Felipe Lanzarin
 */
public class InserirContato {

    public boolean inserir(Contato contato) throws SQLException{

        String sql = "insert into contato (codigo, nome, email, cep, endereco, complemento, emailalternativo) values (?,?,?,?,?,?,?)";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        pst.setInt(1, obterCodigo());
        pst.setString(2, contato.getNome());
        pst.setString(3, contato.getEmail());
        pst.setInt(4, contato.getCep().getCep());
        pst.setString(5, contato.getEndereco());
        pst.setString(6, contato.getComplemento());
        pst.setString(7, contato.getEmailAlternativo());
        pst.executeUpdate();
        pst.close();

         Twitter t = new Twitter();
         t.twittar("O Contato " + contato.getNome() + " foi adicionado com sucesso!!");
        return true;
    }
    private Integer obterCodigo() throws SQLException {

        Integer codigo = null;
        Statement st = Conexao.getStatement();
        ResultSet rs = st.executeQuery("select max(codigo) from contato;");
        rs.next();
        codigo = rs.getInt(1);
        st.close();
        if (codigo == null) {
            codigo = 1;
        } else {
            codigo++;
        }
        
        return codigo;

    }
}
