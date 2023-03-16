/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.LivroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class LivroCadastrarDAO {
    
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarLivro(LivroDTO objlivroDTO) {
    
        String sql = "INSERT INTO tabelaLivros(nomeL,autorL,secaoL) VALUES(?,?,?)";

            conn = new ConexaoDAO().ConectaBD();

            try {
                pstm = conn.prepareStatement(sql);
                
                pstm.setString(1, objlivroDTO.getNome_livro());
                pstm.setString(2,objlivroDTO.getAutor_livro());
                pstm.setString(3,objlivroDTO.getSecao_livro());
                pstm.setInt(4, objlivroDTO.getId_livro());

                pstm.execute();
                pstm.close();

            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "LivroCadastrarDAO: " + e);
        }
    }
}
