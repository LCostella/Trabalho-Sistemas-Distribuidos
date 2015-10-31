/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Cidade;
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
public class InserirCidade {
    Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    public boolean inserir(){
        try {
            String sql = "insert into cidade values (?,?,?)";
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            cidade.setCodigo(obterCodigo());
            pst.setInt(1,cidade.getCodigo());
            pst.setString(2, cidade.getNome());
            pst.setString(3, cidade.getEstado());
            pst.executeUpdate();
            pst.close();
            Conexao.close();  
        } catch (SQLException ex) {
            Logger.getLogger(InserirCidade.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.close();  
            return false;
        } catch (Exception ex) {
            Logger.getLogger(InserirCidade.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.close();  
            return false;
        }
        return true;
    }
    
    private Integer obterCodigo() throws Exception {

        Integer codigo = null;
        Statement st = Conexao.getStatement();
        ResultSet rs = st.executeQuery("select max(codigo) from cidade;");
        rs.next();
        codigo = rs.getInt(1);
        st.close();
        Conexao.close();
        if (codigo == null) {
            codigo = 1;
        } else {
            codigo++;
        }
        
        return codigo;

    }
    
}
