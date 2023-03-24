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
public class TratamentoDAO {
    PreparedStatement pstm;
    Connection conn = new ConexaoDAO().ConectaBD();
    
    public void InsertLivroBd(String nome, String autor, String seccao, int quantidade) {
        try {
            
            String sql = "INSERT INTO tabelaLivros(nomeL,autorL,secaoL,quantidadeL) VALUES(?,?,?,?)";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2,autor);
            pstm.setString(3,seccao);
            pstm.setInt(4,quantidade);
            
            pstm.execute();
            pstm.close();

            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
        public void DeleteLivroBd(int idLivro) {
		
        try {
            String sql = "DELETE FROM tabelaLivros WHERE idL = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);                    



           stmt.setInt(1, idLivro);            
   
            
 
           stmt.execute();
           stmt.close();

            
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        } }
        
        public void UpdateLivroBd(String nome,String autor,String seccao ,int quantidade ,int id){
            
             try {
            
            String sql = "UPDATE tabelaLivros set nomeL =?, autorL = ?, secaoL = ?, quantidadeL = ? WHERE idL = ? ;";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2,autor);
            pstm.setString(3,seccao);
            pstm.setInt(4,quantidade);
            pstm.setInt(5, id);
            
            pstm.execute();
            pstm.close();

            System.out.println("Gravado!");
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            
        }
        
        public void InsertAutorBd(String autor, String nlivros, int best) {
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
       
        public void UpdateAutorBd( String autor, String best, int numero,int id) {
           String sql = "UPDATE tabelaAutores set autorA =?, bestA = ?, nlivroA = ? WHERE idA = ? ;";    

            try {
                pstm = conn.prepareStatement(sql);

                pstm.setString(1,autor ); //1 -> =?
                pstm.setString(2,best ); //2 -> =?
                pstm.setInt(3,numero ); //3 -> =?
                pstm.setInt(4,id ); //4 -> =?

                pstm.execute();
                pstm.close();
                
              JOptionPane.showMessageDialog(null, "Alterado com sucesso!");  
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "UpdateAutorDAO: " + erro);
            }
        
    }
}
