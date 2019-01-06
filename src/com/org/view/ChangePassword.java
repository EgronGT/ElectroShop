package com.org.view;

//import com.org.general.MainClass;
import com.org.main.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ChangePassword extends javax.swing.JFrame {
    
    /** Creates new form ChangePassword */
    public ChangePassword() {
        initComponents();
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        TxtNewPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        TxtConfirmPassword = new javax.swing.JPasswordField();
        CmdOk = new javax.swing.JButton();
        CmdClose = new javax.swing.JButton();
        labelMessage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtOldPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password Page");
        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(750, 550));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        jPanel1.add(TxtNewPassword);
        TxtNewPassword.setBounds(330, 220, 161, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 290, 131, 29);
        jPanel1.add(TxtConfirmPassword);
        TxtConfirmPassword.setBounds(330, 290, 161, 29);

        CmdOk.setBackground(new java.awt.Color(0, 0, 0));
        CmdOk.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CmdOk.setForeground(new java.awt.Color(255, 255, 255));
        CmdOk.setText("Ok");
        CmdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdOkActionPerformed(evt);
            }
        });
        jPanel1.add(CmdOk);
        CmdOk.setBounds(440, 440, 105, 32);

        CmdClose.setBackground(new java.awt.Color(0, 0, 0));
        CmdClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CmdClose.setForeground(new java.awt.Color(255, 255, 255));
        CmdClose.setText("Close");
        CmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdCloseActionPerformed(evt);
            }
        });
        jPanel1.add(CmdClose);
        CmdClose.setBounds(190, 440, 105, 32);
        jPanel1.add(labelMessage);
        labelMessage.setBounds(120, 470, 44, 33);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Old Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 150, 131, 17);
        jPanel1.add(TxtOldPassword);
        TxtOldPassword.setBounds(330, 150, 161, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Password:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 220, 131, 17);

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Change Your Password");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 20, 420, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/image/changePass.gif"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 750, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CmdOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdOkActionPerformed
        
        try {

        if (TxtOldPassword.getText().isEmpty()==true) {
            JOptionPane.showMessageDialog(null,"Enter Old Password.");
            return;
        }
        
        if (TxtNewPassword.getText().isEmpty()==true) {
            JOptionPane.showMessageDialog(null,"Enter New Password.");
            return;
        }
        if (TxtNewPassword.getText().equals(TxtConfirmPassword.getText() )==false) {
            JOptionPane.showMessageDialog(null,"New and Confirm passwords are not matched.");
            return;
        }  
        if(TxtNewPassword.getText().length()<=4){
            
            JOptionPane.showMessageDialog(null,"Pass is NOT OK too short.");
            return;
        }
            //get database connection details
            Main mc=new Main();
            
            //open connection
            Connection connection;
            connection=DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd);
            String str="";
            str="select * from provas where Username =? and Password =?";
            PreparedStatement pst=connection.prepareStatement(str);
            pst.setString(1, Main.StrUser);
            pst.setString(2, TxtOldPassword.getText());
            ResultSet rs;
            rs=pst.executeQuery();
            if (rs.next()) {
                //Update password
               String sql = "UPDATE provas SET Password='" + TxtNewPassword.getText() + "' WHERE Username = '" + Main.StrUser +"'";

               pst.executeUpdate(sql);
               JOptionPane.showMessageDialog(null,"Password updated.");
               this.setVisible(false);
                
            } else {
                JOptionPane.showMessageDialog(null,"Old password are not correct.");
                return;
            }
             
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }//GEN-LAST:event_CmdOkActionPerformed

    private void CmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdCloseActionPerformed
        // Close project
        this.setVisible(false);
    }//GEN-LAST:event_CmdCloseActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        //JOptionPane.showMessageDialog(rootPane, MainClass.StrUser);
        
    }//GEN-LAST:event_formWindowOpened
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CmdClose;
    private javax.swing.JButton CmdOk;
    private javax.swing.JPasswordField TxtConfirmPassword;
    private javax.swing.JPasswordField TxtNewPassword;
    private javax.swing.JPasswordField TxtOldPassword;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMessage;
    // End of variables declaration//GEN-END:variables
    
}
