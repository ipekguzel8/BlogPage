package com.uniyaz.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static final String driverName="com.mysql.cj.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/ipekblog?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    static final String userName="root";
    static final String password="1255896149";
    static Connection connection=null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        connection= DriverManager.getConnection(url,userName,password);
        return connection;
    }
}
