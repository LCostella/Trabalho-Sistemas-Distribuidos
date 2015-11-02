package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Cidade;
import distribuidos.sistemas.trabalho.classes.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Felipe
 */
public class BuscarContato {
    
    private Map <Contato, Integer> map;


    
    
    public List<Contato> listar(Cidade cidade) throws SQLException{
        List<Contato> contatos = new ArrayList<>();

        String sql = "select contato.codigo, contato.nome, contato.email " +
                    "from contato, cep " +
                    "where cep.codigocidade = ?" +
                    " and contato.cep = cep.cep;";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        pst.setInt(1, cidade.getCodigo());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Contato c = new Contato();
            c.setCodigo(rs.getInt("codigo"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            contatos.add(c);
        }
        pst.close();
        Conexao.close();
        return contatos;
    }
    
    
    public Contato buscarContato(int codigo) throws SQLException{
        Contato c = null;
        String sql = "SELECT * FROM contato where codigo = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            map = new HashMap<>();
            c = montarContato(rs);  
        }
        pst.close();
        Conexao.close();
        BuscarCep bc = new BuscarCep();
        if (c!=null){
            c.setCep(bc.buscarCep(map.get(c)));
        }        
        return c;
    }

    public List<Contato> listar(int codigo) throws SQLException {
        List<Contato> contatos = new ArrayList<>();

        String sql = "select * " +
                    "from contato " +
                    "where contato.codigo = ?";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            map = new HashMap<>();
            contatos.add(montarContato(rs));
        }
        pst.close();
        Conexao.close();
        BuscarCep bc = new BuscarCep();
        for(Contato c : contatos){
            c.setCep(bc.buscarCep(map.get(c)));
        }
        return contatos;
    }
    
    private Contato montarContato(ResultSet rs) throws SQLException{
        Contato c = new Contato();
        c.setCodigo(rs.getInt("codigo"));
        c.setNome(rs.getString("nome"));
        c.setEmail(rs.getString("email"));
        c.setComplemento(rs.getString("complemento"));
        c.setEndereco(rs.getString("endereco"));
        c.setEmailAlternativo(rs.getString("emailalternativo"));
        map.put(c, rs.getInt("cep"));
        return c;
    }


}
