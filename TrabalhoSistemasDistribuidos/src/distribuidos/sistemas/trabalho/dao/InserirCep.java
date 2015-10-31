/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Cep;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class InserirCep {

    public boolean inserir(Cep cep){
        String sql = "insert into cep values (?,?)";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, cep.getCep());
            pst.setInt(2, cep.getCidade().getCodigo());
            pst.executeUpdate();
            pst.close();
            Conexao.close();  
        } catch (SQLException ex) {
            Logger.getLogger(InserirCidade.class.getName()).log(Level.SEVERE, null, ex);
            Conexao.close(); 
            return false;
        }
        return true;
    }
}
