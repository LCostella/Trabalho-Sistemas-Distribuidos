/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistema.trabalho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johni e Eliardo
 */
public class Conexao {
    static String url = "jdbc:postgresql://localhost/postgres";
    static String driver = "org.postgresql.Driver";
    static String usuario = "postgres";
    static String senha = "masterkey"; 
    
    static Connection con = null;

    public static Connection getConexao() {

        try {
            if ((con == null) || (con.isClosed())) {
                //2) Registrar a classe do driver de implementação JDBC
                Class.forName(driver);
                //4) Criar a conexão com o BD
                con = DriverManager.getConnection(url, usuario, senha);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    public static Statement getStatement() {
        try {
            return getConexao().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConexao().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        con = null;
    }
}

    

