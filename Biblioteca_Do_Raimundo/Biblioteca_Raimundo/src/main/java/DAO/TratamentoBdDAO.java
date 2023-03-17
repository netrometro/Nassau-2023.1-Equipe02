/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Lima
 * @author Gabriel Luiz
 * @author Samuel Ruan
 */
public class TratamentoBdDAO {

public void InsertLivroBd(String nome, String autor,String seccao,int qtdLivros) {

        try {

            Connection con = null;
            try {
                con = DriverManager.getConnection(
                        "jdbc:sqlite:db/dbBiblioteca.db");
                
                 
            } catch (java.sql.SQLException e1) {

                e1.printStackTrace();
            }
            
            

            String sql = "INSERT INTO tblLivros(nome,autor,seccao,qtdLivros) VALUES(?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2,autor);
            stmt.setString(3,seccao);
            stmt.setInt(4,qtdLivros);
            
            

            stmt.execute();
            stmt.close();

            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Errou ao Gravar No Insert");
        }

    }
}
