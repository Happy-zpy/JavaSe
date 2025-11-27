package com.zpy.JDBC;
import com.mysql.cj.jdbc.Driver;
import org.junit.Test;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws Exception {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/zpy_bd1";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zpy");
        properties.setProperty("url", url);
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.store(new FileWriter("src\\mysql.properties"),"JDBC");
        Connection connection = driver.connect(url, properties);

    }
    @Test
    public void connect() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new BufferedReader(new FileReader("src\\mysql.properties")));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
    }

    public static void connectionTest() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost:3306/zpy_bd1";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zpy");
        Connection connect = driver.connect(url, properties);

    }
    @Test
    public void Connect01() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/zpy_bd1";
        String user = "root";
        String password = "zpy";
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }
}
