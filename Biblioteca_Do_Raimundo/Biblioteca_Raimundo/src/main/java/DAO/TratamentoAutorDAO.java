/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LivroDTO;
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
public class TratamentoAutorDAO {
    PreparedStatement pstm;
    Connection conn = new ConexaoDAO().ConectaBD();
    
    public void InsertLivroBd(String autor, String nlivros, int best) {
        try {
            
            String sql = "INSERT INTO tabelaAutores(autorA,bestA,nlivroA) VALUES(?,?,?)";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, autor);
            pstm.setString(2,nlivros);
            pstm.setInt(3,best);
            
            pstm.execute();
            pstm.close();

            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
