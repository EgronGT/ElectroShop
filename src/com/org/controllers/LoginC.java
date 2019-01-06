/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.controllers;

import com.org.models.LoginM;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class LoginC {


    public void validate(String u, String p){
        LoginC l = new LoginC();
                        
        if (u.isEmpty()|| p.isEmpty())
        {         
            System.out.println("Cant be empty!!");
            
            JOptionPane.showMessageDialog(null,"User name or password Can not be empty.");
         
        }else{
            LoginM lm = new LoginM();
            lm.loginQuery(u, p);
            System.out.println("Entered in else, and run the DB query!!");
        }
           
    }  
    
}
