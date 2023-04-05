/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LivroDTO;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class TratamentoDAO {
    PreparedStatement pstm;
    Connection conn = new ConexaoDAO().ConectaBD();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date data = new Date();
    
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
        
        public void UpdateLivroBd(String nome,String autor,String secao ,int quantidade ,int id){
            
             try {
            
            String sql = "UPDATE tabelaLivros set nomeL =?, autorL = ?, secaoL = ?, quantidadeL = ? WHERE idL = ? ;";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2,autor);
            pstm.setString(3,secao);
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
        
        public void InsertFuncionarioBd(String funcionario, String cargo, String turno, String contato) {
        try {
            
            String sql = "INSERT INTO tabelaFuncionarios(funcionarioF, cargoF, turnoF, contatoF) VALUES(?,?,?,?)";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, funcionario);
            pstm.setString(2,cargo);
            pstm.setString(3, turno);
            pstm.setString(4,contato);
            
            
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


    public void DeleteAutorBd(int idA) {
        try {
            String sql = "DELETE FROM tabelaAutores WHERE idA = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);                    


           stmt.setInt(1, idA);            
   
             
           stmt.execute();
           stmt.close();

            
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        }
    }


        public void InsertAlugarLivroBd(String nome, int id) {

        try {
            
            String sql = "INSERT INTO tabelaAluguelLivros(idAL, nomeAL,dataAL) VALUES(?,?,?)";
            
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1,id);
            pstm.setString(2, nome);
            pstm.setString(3, dateFormat.format(data).toString());
            
            
            pstm.execute();
            pstm.close();

            

            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public void UpdateAlugarLivroBd(int quantidade ,int id){
            
             try {
            
            String sql = "UPDATE tabelaLivros set quantidadeL = ? WHERE idL = ? ;";

            pstm = conn.prepareStatement(sql);

            
            pstm.setInt(1,quantidade);
            pstm.setInt(2, id);
            
            pstm.execute();
            pstm.close();

            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            
    }
          
         public void DeleteAlugarLivroBd(int idLivro,String data) {
		
            try {
            String sql = "DELETE FROM tabelaAluguelLivros WHERE idAL = ? AND dataAL = ?";

            
            PreparedStatement stmt = conn.prepareStatement(sql);                    

           stmt.setInt(1, idLivro);    
           stmt.setString(2, data);
   
            

           stmt.execute();
           stmt.close();

            
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        }
    }
        
     public void UpdateDevolverLivroBd(int id){
             
             int quantidade = SelectQuantidade(id);
             System.out.println(quantidade);
             try {
            
            String sql = "UPDATE tabelaLivros set quantidadeL = ? WHERE idL = ? ;";

            pstm = conn.prepareStatement(sql);

            
            pstm.setInt(1,quantidade);
            pstm.setInt(2, id);
            
            pstm.execute();
            pstm.close();

            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }
            
        public int SelectQuantidade(int id){
            int quantidade =0;
           
              String sql = "SELECT quantidadeL FROM tabelaLivros WHERE idL = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet executarQuery = pstm.executeQuery();
          
         
              
                
                quantidade = executarQuery.getInt("quantidadeL");
            pstm.execute();
            pstm.close();
         
               
        } catch (SQLException sqlex) {
        
        }
            
             return quantidade+1;
        }
            
        }

 public void UpdateFuncionarioDAO( String funcionario, String cargo, String turno, String contato, int id) {
           String sql = "UPDATE tabelaFuncionarios set funcionariosF =?, cargoF = ?, turnoF = ?, contatoF = ? WHERE idF = ? ;";    


            try {
                pstm = conn.prepareStatement(sql);

                pstm.setString(1,funcionario ); //1 -> =?
                pstm.setString(2,cargo ); //2 -> =?
                pstm.setString(3,turno ); //3 -> =?
                pstm.setString(4,contato ); //4 -> =?
                pstm.setInt(5,id ); //5 -> =?

                pstm.execute();
                pstm.close();
                
              JOptionPane.showMessageDialog(null, "Alterado com sucesso!");  
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "UpdateFuncionarioDAO: " + erro);
            }
        
    }

    public void DeleteFuncionarioDAO(int id) {
        try {
            String sql = "DELETE FROM tabelaFuncionarios WHERE idF = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
           stmt.execute();
           stmt.close();

            
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        }
    }
