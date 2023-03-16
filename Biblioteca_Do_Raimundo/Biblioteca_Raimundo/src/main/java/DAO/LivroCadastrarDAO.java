/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class LivroCadastrarDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void InsertLivroBd(String nome, String autor, String seccao) {
        try {

            try {
                conn = DriverManager.getConnection(
             "jdbc:sqlite:db/dbBiblioteca.db");
                
                Statement statement = conn.createStatement();
                
                statement.execute("CREATE TABLE IF NOT EXISTS tabelaLivros(nomeL VARCHAR, autorL VARCHAR, secaoL VARCHAR)");
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "LivroCadastroDAO. Conexão: " + e1);
            }
            String sql = "INSERT INTO tabelaLivros(nomeL,autorL,secaoL) VALUES(?,?,?)";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2,autor);
            pstm.setString(3,seccao);
            
            pstm.execute();
            pstm.close();

            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
