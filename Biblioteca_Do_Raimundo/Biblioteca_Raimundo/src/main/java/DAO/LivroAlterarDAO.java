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
 * @author gabriel
 */
public class LivroAlterarDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void alterarLivro(LivroDTO objlivroDTO) {
        String sql = "Update tabelaLivros set nomeL =?, autorL =?, secaoL =? where idL =?";
        
        conn = new ConexaoDAO().ConectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objlivroDTO.getNome_livro()); //1 -> =?
            pstm.setString(2, objlivroDTO.getAutor_livro()); //2 -> =?
            pstm.setString(3, objlivroDTO.getSecao_livro()); //3 -> =?
            pstm.setInt(4, objlivroDTO.getId_livro()); //4 -> =?
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "LivroAlterarDAO: " + erro);
        }
        
    }
    
}
