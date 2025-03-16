package hotelmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class Con {
    private final static String URL ="jdbc:mysql://localhost:3306/javaproject";
     private final static String USERNAME="root";
       private final static String PASSWORD="root";
       public static Connection getConnection() {
         Connection connection=null;
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
              //System.out.println("class loaded successfully");
               connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             // System.out.println("connection successfully");

          } catch (Exception e) {
              System.out.println("connection not successfull");
           }
           return connection;
      }
    }


