/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelinhas;

import banco.ConnectionException;
import daos.JogadorDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import usuario.Jogador;

/**
 *
 * @author AlexaLins
 */
public class NovoUsuario extends javax.swing.JFrame {
    JogadorDao dao = null;
    /**
     * Creates new form NovoUsuario
     */
    public NovoUsuario() throws Exception {
        dao = new JogadorDao();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPasswordField4 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("League of Legends");
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Senha");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(54, 140, 43, 17);
        getContentPane().add(jPasswordField4);
        jPasswordField4.setBounds(209, 194, 110, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(209, 45, 110, 30);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(165, 249, 70, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(209, 91, 107, 30);
        getContentPane().add(jPasswordField3);
        jPasswordField3.setBounds(209, 140, 110, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 122, 400, 10);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Login");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(54, 94, 38, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Senha novamente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(54, 197, 125, 17);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(54, 48, 41, 17);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\AlexaLins\\Documents\\NetBeansProjects\\LoLzin\\lol.jpg")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(4, -6, 390, 300);

        setSize(new java.awt.Dimension(412, 334));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome = jTextField1.getText();
        String login = jTextField2.getText();
        String senha1 = jPasswordField3.getText();
        String senha2 = jPasswordField4.getText();
        
        if(senha1.hashCode()==senha2.hashCode()){
            Jogador jogador = new Jogador(login, senha2);
        
            jogador.setNome(nome);
            jogador.setLogin(login);
            jogador.setSenha(senha1);
            
            try {
            if (dao.add(jogador)) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                limparFormulario();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            } catch (SQLException ex) {
            Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
           JOptionPane.showMessageDialog(null, "Senhas diferentes", "Erro", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NovoUsuario().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

private void limparFormulario() {
        jTextField1.setText("");
        jTextField2.setText("");
        jPasswordField3.setText("");
        jPasswordField4.setText("");
}
}
