/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.dao;

import distribuidos.sistemas.trabalho.classes.Cep;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class BuscarCep {
    
    public Cep buscarCep(int cep) throws SQLException{
        Cep c = null;
        int codigoCidade = 0;
        String sql = "SELECT * FROM cep where cep = ?";
       PreparedStatement pst = Conexao.getPreparedStatement(sql);
        pst.setInt(1, cep);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            c = new Cep();
            c.setCep(rs.getInt("cep"));
            codigoCidade = rs.getInt("codigocidade");  
        }
        pst.close();
        Conexao.close();
        BuscarCidade lc = new BuscarCidade();
        if(c!=null){
            c.setCidade(lc.buscarCidade(codigoCidade)); 
        }
        return c;           
    }
}
