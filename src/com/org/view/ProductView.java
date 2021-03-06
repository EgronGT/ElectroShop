 

package com.org.view;

import com.org.models.ProductClass;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EgronGT
 */
public class ProductView extends javax.swing.JFrame {

    /** Creates new form Main */
    public ProductView() {
        initComponents();
//        getConnection();
//        Show_Products_In_JTable();
    }
    String ImgPath = null;
    int pos = 0;
    
    
public Connection getConnection()
{
    Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/project_products", "root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}

//public boolean checkInputs()
//{
//    if (     
//            txt_name.getText()== null
//            || txt_price.getText() == null
//            || txt_AddDate.getDate()== null
//                    )
//    {
//        return false;
//    
//}
//else{
//        try{
////            Float.parseFloat(txt_price.getText());
//            return true;
//        }catch(Exception ex)
//        {
//            return false;
//    }
//}
//
//}
public ImageIcon ResizeImage(String imagePath, byte[] pic)
{
    ImageIcon myImage = null;
    if(imagePath !=null)
    {
        myImage = new ImageIcon(imagePath);
    }else {
        myImage = new ImageIcon(pic);
        
    }
    Image img = myImage.getImage();
    Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(img2);
    return image;

}

 public ArrayList<ProductClass> getProductList()
 {
            ArrayList<ProductClass> productList= new ArrayList<ProductClass>();
            Connection con = getConnection();
            String query = " SELECT * FROM products";
            
            Statement st;
            ResultSet rs;
            
        try {
            st = con.createStatement();
            rs= st.executeQuery(query);
            ProductClass product;
            
            while(rs.next())
            {
                product = new ProductClass(rs.getInt("id"),rs.getString("name"),Float.parseFloat(rs.getString("price")), rs.getString("add_date"),rs.getBytes("image"));
                productList.add(product);
//                        .add(product);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
     
 }

// public void Show_Products_In_JTable()
// {
//     ArrayList<Product> list = getProductList();
//     DefaultTableModel model =(DefaultTableModel) JTable_Products.getModel();
//     
//     
//     model.setRowCount(0);
//     Object[] row= new Object[4];
//     for (int i = 0; i < list.size(); i++) 
//     {
//         row[0] = list.get(i).getId();
//         row[1] = list.get(i).getName();
//         row[2] = list.get(i).getPrice();
//         row[3] = list.get(i).getAddDate();
//         
//         model.addRow(row);
//         
//     }
// }
  public void ShowItem(int index)
  {
            txt_id.setText(Integer.toString(getProductList().get(index).getId()));
            txt_name.setText(getProductList().get(index).getName());
            txt_price.setText(Float.toString(getProductList().get(index).getPrice()));
           
        try {
             Date addDate=null;
            addDate= new SimpleDateFormat("yyy-MM-dd").parse((String)getProductList().get(index).getAddDate());
        txt_AddDate.setDate(addDate);
        } catch (ParseException ex) {
            Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_image.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
  }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        Btn_Next = new javax.swing.JButton();
        Btn_Previus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_AddDate = new org.jdesktop.swingx.JXDatePicker();
        txt_price = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        Btn_First = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        Btn_Next.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Btn_Next.setText("Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Next);
        Btn_Next.setBounds(410, 570, 151, 31);

        Btn_Previus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Btn_Previus.setText("Previus");
        Btn_Previus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviusActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Previus);
        Btn_Previus.setBounds(160, 570, 140, 31);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Price:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(760, 200, 68, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(780, 60, 47, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(740, 130, 80, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(760, 270, 68, 28);

        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/image/leuke-792623125.gif"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(780, 330, 200, 120);

        txt_AddDate.setEditable(false);
        jPanel1.add(txt_AddDate);
        txt_AddDate.setBounds(840, 270, 146, 35);

        txt_price.setEditable(false);
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        jPanel1.add(txt_price);
        txt_price.setBounds(840, 200, 146, 35);

        txt_name.setEditable(false);
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_name);
        txt_name.setBounds(840, 130, 146, 35);

        txt_id.setEditable(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel1.add(txt_id);
        txt_id.setBounds(840, 60, 146, 35);

        Btn_First.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Btn_First.setText("First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_First);
        Btn_First.setBounds(870, 490, 140, 31);

        Btn_Last.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Btn_Last.setText("Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Last);
        Btn_Last.setBounds(870, 540, 140, 31);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        lbl_image.setBackground(new java.awt.Color(0, 0, 0));
        lbl_image.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 13, 721, 540);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/org/image/2.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 1030, 610);

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Update");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_PreviusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviusActionPerformed
        pos--;
        if(pos<0)
        {
            pos =0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_PreviusActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        
        pos=0;
        ShowItem(pos);
        
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
         
        pos = getProductList().size()-1;
        ShowItem(pos);
        
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
         
        pos++;
        
        if(pos >= getProductList().size())
        {
            pos = getProductList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel lbl_image;
    private org.jdesktop.swingx.JXDatePicker txt_AddDate;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables

    private InputStream FileInputStream(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
