/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.view;

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import mp.dao.UsuarioDAO;
import mp.model.Usuario;
import mp.model.UsuarioComum;
import mp.model.UsuarioVIP;

/**
 *
 * @author maria
 */
public class JFUsuarios extends javax.swing.JFrame {

    private UsuarioDAO usuarioDAO;
    private DefaultTableModel tableModel;
    private Usuario usuarioLogado;
    String currentSelectedUser = null;

    /**
     * Creates new form JFCadastrarUsuario
     */
    public JFUsuarios() {
        initComponents();
        setDetails();
        loadUsersOnJTable();
        clearCadastro();
    }

    /**
     * Creates new form JFCadastrarUsuario
     */
    public JFUsuarios(Usuario usuario) {
        initComponents();
        setDetails();
        loadUsersOnJTable();
        clearCadastro();
        usuarioLogado = usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jCheckBoxVIP = new javax.swing.JCheckBox();
        jTextUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jPasswordFieldConfirma = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButtonEnter = new javax.swing.JButton();
        jLabelTituloAnexo = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jLabelMessageErros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jLabelMessageAcoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gem Music Player - Cadastrar usuário");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanelCadastro.setBackground(new java.awt.Color(102, 153, 0));
        jPanelCadastro.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");

        jTextNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });

        jCheckBoxVIP.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jCheckBoxVIP.setText("VIP");

        jTextUser.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha");

        jPasswordField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jPasswordFieldConfirma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirmar senha");

        jButtonEnter.setBackground(new java.awt.Color(153, 204, 0));
        jButtonEnter.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButtonEnter.setForeground(new java.awt.Color(51, 51, 51));
        jButtonEnter.setText("Cadastrar/Editar");
        jButtonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnterActionPerformed(evt);
            }
        });

        jLabelTituloAnexo.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabelTituloAnexo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloAnexo.setText("Titulo...");

        jButtonCancelar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancelar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(51, 51, 51));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelMessageErros.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelMessageErros.setForeground(new java.awt.Color(255, 0, 51));
        jLabelMessageErros.setText("mensagem...");

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextUser)
                                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxVIP))
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordFieldConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMessageErros)))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabelTituloAnexo)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTituloAnexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxVIP))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(56, 56, 56)))
                .addComponent(jButtonEnter)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addGap(51, 51, 51)
                .addComponent(jLabelMessageErros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableUsers.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTableUsers.setForeground(new java.awt.Color(102, 153, 0));
        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Usuário", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(jTableUsers);

        jLabelTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_gem.png"))); // NOI18N
        jLabelTitulo.setText("Usuários");

        jButtonAdd.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_plus.png"))); // NOI18N
        jButtonAdd.setToolTipText("Adicionar novo usuário");
        jButtonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRemover.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_minus.png"))); // NOI18N
        jButtonRemover.setToolTipText("Remover usuário selecionado");
        jButtonRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp/view/icons/if_edit.png"))); // NOI18N
        jButtonEditar.setToolTipText("Editar usuário selecionado");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jLabelMessageAcoes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelMessageAcoes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMessageAcoes.setText("mensagem...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelMessageAcoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonRemover)
                        .addComponent(jButtonAdd)
                        .addComponent(jButtonEditar))
                    .addComponent(jLabelMessageAcoes))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        clearCadastro();
        jLabelTituloAnexo.setText("Cadastrar usuário");
        jButtonEnter.setText("Cadastrar");
        jPanelCadastro.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        jLabelMessageAcoes.setVisible(false);

        //o index vai indicar o numero da linha que deve ser exluida
        //getSelectedRow() : Returns the index of the first selected row, -1 if no row is selected.
        int selectedRowIndex = jTableUsers.getSelectedRow();

        if (selectedRowIndex != -1) {
            usuarioDAO.delete(selectedRowIndex);
            loadUsersOnJTable();
            jLabelMessageAcoes.setText("Usuário excluido com sucesso");
        } else {
            jLabelMessageAcoes.setText("Selecione um usuário para excluir");
        }
        jLabelMessageAcoes.setVisible(true);
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnterActionPerformed
        jLabelMessageErros.setVisible(false);
        jLabelMessageAcoes.setVisible(false);

        boolean preenchimentoDeCampos = jTextUser.getText().equals("") || jTextUser.getText().equals("")
                || jPasswordField.getText().equals("") || jPasswordFieldConfirma.getText().equals("");

        boolean confirmacaoDeSenha = jPasswordField.getText().equals(jPasswordFieldConfirma.getText());

        boolean usuarioJaExiste = usuarioDAO.alreadyExist(jTextUser.getText());

        if (preenchimentoDeCampos) {
            jLabelMessageErros.setText("Preencha todos os campos");
            jLabelMessageErros.setVisible(true);
        } else if (!confirmacaoDeSenha) {
            jLabelMessageErros.setText("As senhas não correspondem");
            jLabelMessageErros.setVisible(true);
        } else if (usuarioJaExiste) {
            jLabelMessageErros.setText("Já temos alguém usando este usuário");
            jLabelMessageErros.setVisible(true);
        } else {
            Usuario usuario;
            
            if (jCheckBoxVIP.isSelected()) {
                usuario = new UsuarioVIP(jTextNome.getText(), jTextUser.getText(), jPasswordField.getText(), "VIP");
            } else {
                usuario = new UsuarioComum(jTextNome.getText(), jTextUser.getText(), jPasswordField.getText(), "Comum");
            }

            if (jButtonEnter.getText().equals("Cadastrar")) {
                usuarioDAO.insert(usuario);
                jLabelMessageAcoes.setText("Usuário adicionado com sucesso");
            } else {
                usuarioDAO.edit(usuario, currentSelectedUser);
                jLabelMessageAcoes.setText("Usuário editado com sucesso");
            }

            clearCadastro();
            loadUsersOnJTable();
            jLabelMessageAcoes.setVisible(true);
        }
    }//GEN-LAST:event_jButtonEnterActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        clearCadastro();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        jLabelMessageAcoes.setVisible(false);
        clearCadastro();

        //getSelectedRow() : Returns the index of the first selected row, -1 if no row is selected.
        int selectedRowIndex = jTableUsers.getSelectedRow();

        if (selectedRowIndex != -1) {
            jLabelTituloAnexo.setText("Editar usuário");
            jButtonEnter.setText("Editar");
            jPanelCadastro.setVisible(true);

            usuarioDAO = new UsuarioDAO();
            currentSelectedUser = tableModel.getValueAt(selectedRowIndex, 1).toString();
            String currentType =tableModel.getValueAt(selectedRowIndex, 2).toString();
            String currentPass = usuarioDAO.getSenha(currentSelectedUser);
            

            jTextNome.setText(tableModel.getValueAt(selectedRowIndex, 0).toString());
            jTextUser.setText(tableModel.getValueAt(selectedRowIndex, 1).toString());
            jPasswordField.setText(currentPass);
            jPasswordFieldConfirma.setText(currentPass);
            
            if(currentType.equals("VIP")) {
                jCheckBoxVIP.setSelected(true);
            } else {
                jCheckBoxVIP.setSelected(false);
            }
        } else {
            jLabelMessageAcoes.setText("Selecione um usuário para editar");
            jLabelMessageAcoes.setVisible(true);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

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
            java.util.logging.Logger.getLogger(JFUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new JFUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEnter;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JCheckBox jCheckBoxVIP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelMessageAcoes;
    private javax.swing.JLabel jLabelMessageErros;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloAnexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordFieldConfirma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsers;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextUser;
    // End of variables declaration//GEN-END:variables

    private void setDetails() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/if_gem.png")));
        this.getRootPane().setDefaultButton(jButtonEnter);
        jPanelCadastro.setVisible(false);
        jLabelMessageAcoes.setVisible(false);
        jTableUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableModel = (DefaultTableModel) jTableUsers.getModel();
        usuarioDAO = new UsuarioDAO();
    }

    private void clearCadastro() {
        jTextNome.setText("");
        jTextUser.setText("");
        jPasswordField.setText("");
        jPasswordFieldConfirma.setText("");
        jCheckBoxVIP.setEnabled(true);
        jCheckBoxVIP.setSelected(false);
        jPanelCadastro.setVisible(false);
        jLabelMessageErros.setVisible(false);
    }

    private void loadUsersOnJTable() {
        ArrayList<Usuario> usuarios = usuarioDAO.list();

        if (!usuarios.isEmpty()) {
            //limpando jTable
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }

            //adicionando cada linha da lista na jTable
            for (Usuario u : usuarios) {
                tableModel.addRow(new Object[]{
                    u.getNome(),
                    u.getUsuario(),
                    u.getTipo()
                });
            }
        }
    }
}
