package jeep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
 private static final String URL = "jdbc:mysql://localhost:3306/jeeps";
 private static final String USER_NAME = "userme";
 private static final String PASSWORD = "userme";
 
 
 public static Connection getConnection() throws SQLException {
 return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
 

 }
}