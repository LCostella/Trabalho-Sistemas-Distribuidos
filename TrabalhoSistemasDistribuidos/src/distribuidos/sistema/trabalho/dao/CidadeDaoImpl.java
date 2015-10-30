/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistema.trabalho.dao;

import distirbuidos.sistemas.trabalho.classes.Cidade;
import java.sql.PreparedStatement;

/**
 *
 * @author Eliardo Marini
 */
public class CidadeDaoImpl {
    public void inserir(Cidade objeto) throws Exception {
        String sql = "INSERT INTO  cidade (codigo, nome, estado) values (?,?,?)";
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        ps.setInt(1, objeto.getCodigo());
        ps.setString(2, objeto.getNome());
        ps.setString(3, objeto.getEstado());
        ps.executeUpdate();
        ps.close();
        Conexao.close();
}
           
    public void alterar(Cidade objeto) throws Exception {
        String sql = "UPDATE cidade set nome = ?, estado = ? WHERE codigo = ?";
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        ps.setInt(3, objeto.getCodigo());
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getEstado());
        ps.executeUpdate();
        ps.close();
        Conexao.close();
    }
    
   public void remover(Cidade objeto) throws Exception {
        String sql = "DELETE FROM contato where codigo=?";
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        ps.setInt(1, objeto.getCodigo());
        ps.executeUpdate();
        ps.close();
        Conexao.close();
    }
}
