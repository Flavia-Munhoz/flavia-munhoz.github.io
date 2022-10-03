
package br.com.diversasFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    //Fabrica de conexoes
    private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="";

 
            
    public static Connection createConnectionToMySQl(){
        try{
            Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            return connection;
        }  catch (SQLException e){
            throw new RuntimeException(e);
        }
    }  
}
