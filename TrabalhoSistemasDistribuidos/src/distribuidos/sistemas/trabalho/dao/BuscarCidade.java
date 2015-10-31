
package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Cidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class BuscarCidade {
    
    public List<Cidade> listar() throws SQLException{
        List<Cidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM cidade order by nome";
        Statement st = Conexao.getStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Cidade c = new Cidade();
            c.setCodigo(rs.getInt("codigo"));
            c.setNome(rs.getString("nome"));
            c.setEstado(rs.getString("estado"));
            lista.add(c);
        }
        st.close();
        Conexao.close();
        return lista;
    }
    
    public Cidade buscarCidade(int codigo) throws SQLException{
        Cidade c = null;
        String sql = "SELECT * FROM cidade where codigo = "+codigo;
        Statement st = Conexao.getStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            c = new Cidade();
            c.setCodigo(rs.getInt("codigo"));
            c.setNome(rs.getString("nome"));
            c.setEstado(rs.getString("estado"));  
        }
        st.close();
        Conexao.close();
        return c;
    }
    public Cidade buscarCidade(String nome, String estado) throws SQLException{
        Cidade c = null;
        String sql = "SELECT * FROM cidade where nome = ? and estado = ? ";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        pst.setString(1, nome);
        pst.setString(2, estado);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            c = new Cidade();
            c.setCodigo(rs.getInt("codigo"));
            c.setNome(rs.getString("nome"));
            c.setEstado(rs.getString("estado"));  
        }
        pst.close();
        Conexao.close();
        return c;
    }
}
