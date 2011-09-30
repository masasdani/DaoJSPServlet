/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author badak
 */
public class DatabaseUtil {
    public static Connection con;

    public static Connection getConnection(){
        try{
            Class.forName(koneksi.driver);
            con=DriverManager.getConnection(koneksi.database, koneksi.username, koneksi.password);
        }catch(SQLException e){
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, e);
        }catch(ClassNotFoundException e){
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }
}
