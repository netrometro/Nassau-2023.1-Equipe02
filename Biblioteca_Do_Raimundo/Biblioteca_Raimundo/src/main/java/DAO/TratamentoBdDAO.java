/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Lima
 * @author Gabriel Luiz
 * @author Samuel Ruan
 */
public class TratamentoBdDAO {

public void InsertBd(String nome, String autor,String seccao) {

        try {

            Connection con = null;
            try {
                con = DriverManager.getConnection(
                        "jdbc:sqlite::db/bdBiblioteca.bd");
            } catch (java.sql.SQLException e1) {

                e1.printStackTrace();
            }

            String sql = "INSERT INTO tbl_livros(nome,autor,seccao) VALUES(?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2,autor);
            stmt.setString(2,seccao);
            

            stmt.execute();
            stmt.close();

            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
