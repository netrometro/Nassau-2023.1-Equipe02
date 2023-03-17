/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import javax.swing.JOptionPane;
import DTO.*;

/**
 * @author Gabriel Lima
 * @author Gabriel Luiz
 * @author Samuel Ruan
 */
public class TratamentoBdDAO {

    Connection conn;
    PreparedStatement pstm;
    
public void InsertLivroBd(String nome, String autor,String seccao) {

            conn = new ConexaoDAO().ConectaBD();
            try{
            String sql = "INSERT INTO tabelaLivros(nome,autor,secao) VALUES(?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2,autor);
            stmt.setString(3,seccao);
            

            stmt.execute();
            stmt.close();
            }catch(SQLException sqlex){
                JOptionPane.showMessageDialog(null, "TratamentoBdDAO: " + sqlex);
            }
            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }
    public void alterarLivro(LivroDTO objlivroDTO) {
        String sql = "Update tabelaLivros set nome = ?, autor = ?, secao = ? where id = ?";
        
        conn = new ConexaoDAO().ConectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objlivroDTO.getNome_livro()); //1 -> =?
            pstm.setString(2, objlivroDTO.getAutor_livro()); //2 -> =?
            pstm.setString(3, objlivroDTO.getSecao_livro()); //3 -> =?
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TratamentoBdDAO: " + erro);
        }
        
    }
}
