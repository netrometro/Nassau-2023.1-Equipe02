package VIEW;


import VIEW.DashBoardVIEW;

import DAO.*;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioVIEW extends javax.swing.JFrame {

    public void limparCampos (){
        txtFuncionarioVIEW.setText("");
        txtCargoVIEW.setText("");
        txtTurnoVIEW.setText("");
        txtContatoVIEW.setText("");
    }

    TratamentoDAO bd = new TratamentoDAO();
    /**
     * Creates new form frmConsultaVIEW
     */
    public FuncionarioVIEW() {
        initComponents();
        readDatabase();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
        public void readDatabase() {
        Connection conn;
        PreparedStatement pstm;
        conn = new ConexaoDAO().ConectaBD();
        String sql = "SELECT * FROM tabelaFuncionarios";
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet executarQuery = pstm.executeQuery();
            DefaultTableModel autorViewTable = (DefaultTableModel) tabelaFuncionarioVIEW.getModel();
            autorViewTable.setNumRows(0);
            while (executarQuery.next()) {
                autorViewTable.addRow(new Object[]{
                    executarQuery.getString("idF"),
                    executarQuery.getString("funcionariosF"),
                    executarQuery.getString("cargoF"),
                    executarQuery.getString("turnoF"),
                    executarQuery.getString("contatoF"),});
            }

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "FuncionarioVIEW: " + sqlex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarioVIEW = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFuncionarioVIEW = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnCadastrarVIEW = new javax.swing.JButton();
        btnLimparVIEW = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAlterarVIEW = new javax.swing.JButton();
        btnExcluirVIEW = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSairVIEW2 = new javax.swing.JButton();
        txtCargoVIEW = new javax.swing.JTextField();
        txtContatoVIEW = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTurnoVIEW = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LIVRARIA RAI MUNDO");
        jLabel3.setPreferredSize(new java.awt.Dimension(900, 26));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FUNCIONARIOS");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("preencha apenas o que deseja consultar.");

        tabelaFuncionarioVIEW.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "FUNCIONARIO", "CARGO", "TURNO", "CONTATO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionarioVIEW.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaFuncionarioVIEW);
        if (tabelaFuncionarioVIEW.getColumnModel().getColumnCount() > 0) {
            tabelaFuncionarioVIEW.getColumnModel().getColumn(0).setMinWidth(45);
            tabelaFuncionarioVIEW.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        jLabel2.setText("Funcionario:");

        jLabel6.setText("Cargo:");

        txtFuncionarioVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncionarioVIEWActionPerformed(evt);
            }
        });

        jLabel7.setText("Contato:");

        btnCadastrarVIEW.setText("CADASTRAR");
        btnCadastrarVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVIEWActionPerformed(evt);
            }
        });

        btnLimparVIEW.setText("LIMPAR");
        btnLimparVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparVIEWActionPerformed(evt);
            }
        });

        btnAlterarVIEW.setText("ALTERAR");
        btnAlterarVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarVIEWActionPerformed(evt);
            }
        });

        btnExcluirVIEW.setText("EXCLUIR");
        btnExcluirVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVIEWActionPerformed(evt);
            }
        });

        btnAlterar.setText("SALVAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSairVIEW2.setBackground(new java.awt.Color(105, 105, 105));
        btnSairVIEW2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSairVIEW2.setForeground(new java.awt.Color(255, 255, 255));
        btnSairVIEW2.setText("v o l t a");
        btnSairVIEW2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairVIEW2ActionPerformed(evt);
            }
        });

        txtCargoVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoVIEWActionPerformed(evt);
            }
        });

        jLabel1.setText("Turno:");

        txtTurnoVIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTurnoVIEWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSairVIEW2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrarVIEW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterarVIEW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterar)
                                .addGap(124, 124, 124))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFuncionarioVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCargoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTurnoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluirVIEW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimparVIEW))
                            .addComponent(txtContatoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtFuncionarioVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCargoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContatoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTurnoVIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarVIEW)
                    .addComponent(btnLimparVIEW)
                    .addComponent(btnAlterarVIEW)
                    .addComponent(btnExcluirVIEW)
                    .addComponent(btnAlterar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSairVIEW2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVIEWActionPerformed
           if (!txtFuncionarioVIEW.getText().trim().isEmpty() && !txtCargoVIEW.getText().trim().isEmpty() && !txtTurnoVIEW.getText().trim().isEmpty() && !txtContatoVIEW.getText().trim().isEmpty()) {
            
            bd.InsertFuncionarioBd(txtFuncionarioVIEW.getText().toString(), txtCargoVIEW.getText().toString(),txtTurnoVIEW.getText().toString(), txtContatoVIEW.getText().toString());
            
            readDatabase();
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os Campos!");
    }
                           

    }//GEN-LAST:event_btnCadastrarVIEWActionPerformed

    private void btnAlterarVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarVIEWActionPerformed
          if (tabelaFuncionarioVIEW.getSelectedRow() != -1) {
            txtFuncionarioVIEW.setText((String) tabelaFuncionarioVIEW.getValueAt(tabelaFuncionarioVIEW.getSelectedRow(), 1));
            txtCargoVIEW.setText((String) tabelaFuncionarioVIEW.getValueAt(tabelaFuncionarioVIEW.getSelectedRow(), 2));
            txtTurnoVIEW.setText((String) tabelaFuncionarioVIEW.getValueAt(tabelaFuncionarioVIEW.getSelectedRow(), 3));
            txtContatoVIEW.setText((String) tabelaFuncionarioVIEW.getValueAt(tabelaFuncionarioVIEW.getSelectedRow(), 4));
        
        }else{
             JOptionPane.showMessageDialog(null, "Selecione um Funcionário da tabela!");
         }
    }//GEN-LAST:event_btnAlterarVIEWActionPerformed

    private void btnExcluirVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirVIEWActionPerformed
     if (tabelaFuncionarioVIEW.getSelectedRow() != -1) {

            bd.DeleteFuncionarioDAO(Integer.valueOf(tabelaFuncionarioVIEW.getValueAt(tabelaFuncionarioVIEW.getSelectedRow(), 0).toString()));
            readDatabase();
 
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um funcionario para demitir!");

        } 
    }//GEN-LAST:event_btnExcluirVIEWActionPerformed

    private void btnLimparVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparVIEWActionPerformed
       limparCampos();
    }//GEN-LAST:event_btnLimparVIEWActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         if (!txtFuncionarioVIEW.getText().trim().isEmpty() && !txtCargoVIEW.getText().trim().isEmpty() && !txtTurnoVIEW.getText().trim().isEmpty() && !txtContatoVIEW.getText().trim().isEmpty()) {
            bd.UpdateFuncionarioBd(txtFuncionarioVIEW.getText().toString(), txtCargoVIEW.getText().toString(), txtTurnoVIEW.getText().toString(),txtContatoVIEW.getText().toString()  ,Integer.valueOf(tabelaFuncionarioVIEW.getValueAt(tabelaFuncionarioVIEW.getSelectedRow(), 0).toString()));
            
         //   readDatabase();
            limparCampos();
            readDatabase();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os Campos!");

        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSairVIEW2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairVIEW2ActionPerformed
        this.dispose();
        DashBoardVIEW tela = new DashBoardVIEW();
        tela.setVisible(true);
    }//GEN-LAST:event_btnSairVIEW2ActionPerformed

    private void txtFuncionarioVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuncionarioVIEWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncionarioVIEWActionPerformed

    private void txtCargoVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoVIEWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoVIEWActionPerformed

    private void txtTurnoVIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTurnoVIEWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTurnoVIEWActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncionarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterarVIEW;
    private javax.swing.JButton btnCadastrarVIEW;
    private javax.swing.JButton btnExcluirVIEW;
    private javax.swing.JButton btnLimparVIEW;
    private javax.swing.JButton btnSairVIEW2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaFuncionarioVIEW;
    private javax.swing.JTextField txtCargoVIEW;
    private javax.swing.JTextField txtContatoVIEW;
    private javax.swing.JTextField txtFuncionarioVIEW;
    private javax.swing.JTextField txtTurnoVIEW;
    // End of variables declaration//GEN-END:variables

}
