/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.main;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Master
 */
public class Main {
       public String StrUrl="jdbc:mysql://localhost:3306/prova";
    public String StrUid="root";
    public String StrPwd= "";
    public static String StrUser;
   // public static String neser;
    private Connection connection;
    
    public void getConnected(){

        try{                
               //create the connection with the database
               setConnection(DriverManager.getConnection(StrUrl,StrUid,StrPwd));
               System.out.println("Connection with DB established sucessfully!!! in URL: " + StrUrl);
            }catch(Exception ex){
                System.err.println(ex);
                System.exit(1);
            }
    }
            
   

    /**
     * @return the connection
     */
    public Connection getConnection() {
        if(connection==null)
            getConnected();
       
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

    

