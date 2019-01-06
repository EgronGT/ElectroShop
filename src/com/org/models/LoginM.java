
package com.org.models;

import com.org.controllers.LoginC;
import com.org.main.Main;
import com.org.view.AboutUS;
import com.org.view.MainView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class LoginM {
    
     public void loginQuery(String u, String p){
        //get the user input from the controller once they are cleared up
        LoginC lc = new LoginC();
        String stru = u;
        String strp = p;
        
        //get database connection details
        Main mc=new Main();
        mc.getConnected();
        
        try {
           String str="";
           str="select * from provas where Username =? and Password =?";
           PreparedStatement pst=mc.getConnection().prepareStatement(str);
           pst.setString(1, stru);
           pst.setString(2, strp);
           ResultSet rs;
           rs=pst.executeQuery();
           if (rs.next())
           {
               Main.StrUser = stru;
               MainView f=new MainView();
               f.setVisible(true);
           }
           else
           {
                JOptionPane.showMessageDialog(null,"User name or password are not correct.");
                
            }
           
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
        
    }
}
