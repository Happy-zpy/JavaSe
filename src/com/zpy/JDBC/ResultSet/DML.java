package com.zpy.JDBC.ResultSet;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DML {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = conn.prepareStatement("delete from student where id = ?");
        preparedStatement.setInt(1, 32);
//        preparedStatement.setString(2, "男");
//        preparedStatement.setInt(3, 18);
//        preparedStatement.setString(4, "高三九班");
//        preparedStatement.setDouble(5, 99);99
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "成功" : "失败");
    }
}
