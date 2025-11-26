package com.zpy.JDBC.ResultSet;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ResultSet01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        ResultSet resultSet = conn.prepareStatement("select * from student").executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String gender = resultSet.getString(3);
            int age = resultSet.getInt(4);
            String class01 = resultSet.getString(5);
            double store = resultSet.getDouble(6);
            System.out.println(id + "\t" + name + "\t" + gender + "\t" + age + "\t" + class01 + "\t" + store);
        }
        resultSet.close();
        conn.close();


    }
}
