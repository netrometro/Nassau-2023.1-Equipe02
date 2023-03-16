/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Lima
 * @author Gabriel Luiz
 * @author Samuel Ruan
 */
public class ConexaoDAO {   //Mudar nome de class para "ConexaoDAO"

    public Connection ConectaBD() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:sqlite:db/dbBiblioteca.db");

            Statement statement = conn.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS tabelaLivros(nomeL VARCHAR, autorL VARCHAR, secaoL VARCHAR)");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO: " + e);
        }
        return conn;
    }
}
