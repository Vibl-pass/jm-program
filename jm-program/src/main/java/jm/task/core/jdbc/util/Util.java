package jm.task.core.jdbc.util;

//import com.sun.jdi.PrimitiveValue;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final String HOST = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "gthdfcjk2013";
    private Connection connection;
    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
