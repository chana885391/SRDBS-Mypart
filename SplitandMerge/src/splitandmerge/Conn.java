package splitandmerge;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class Conn {
     private static Connection conn;
    public static Connection getConnection() throws Exception{

        if(conn == null){
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SRDBS","SRDBS","terminator");
        }
        return conn;
    }
    
       
}
