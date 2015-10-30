/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistema.trabalho.dao;

import distirbuidos.sistemas.trabalho.classes.Contato;
import java.sql.PreparedStatement;

/**
 *
* @author Eliardo Marini
 */


public class ContatoDaoImpl {
       public void inserir(Contato objeto) throws Exception {
        String sql = "INSERT INTO  contato (codigo, nome, email, endereco, complemento, cep, emailalternatico, codigocidade) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        ps.setInt(1, objeto.getCodigo());
        ps.setString(2, objeto.getNome());
        ps.setString(3, objeto.getEmail());
        ps.setString(4, objeto.getEndereco());
        ps.setString(5, objeto.getComplemento());
        ps.setInt(6, objeto.getCep());
        ps.setString(7, objeto.getEmailAlternativo());
        ps.setInt(8, objeto.getCidade.getCodigo());
        ps.executeUpdate();
        ps.close();
        Conexao.close();
}
       
       
    public void alterar(Contato objeto) throws Exception {
        String sql = "UPDATE Clientes set nome = ?, email = ?, endereco = ?, complemento = ?, cep = ?, emailalternativo = ?, codigocidade = ? WHERE codigo = ?";
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        ps.setInt(8, objeto.getCodigo());
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getEmail());
        ps.setString(3, objeto.getEndereco());
        ps.setString(4, objeto.getComplemento());
        ps.setInt(5, objeto.getCep());
        ps.setString(6, objeto.getEmailAlternativo());
       // ps.setInt(7, objeto.getCidade.getCodigo();
        ps.executeUpdate();
        ps.close();
        Conexao.close();
    }

    public void remover(Contato objeto) throws Exception {
        String sql = "DELETE FROM contato where codigo=?";
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        ps.setInt(1, objeto.getCodigo());
        ps.executeUpdate();
        ps.close();
        Conexao.close();
    }
}