package com.zpy.JDBC.ResultSet;

import Utils.JDBCDruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Druid01 {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCDruidUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String class01 = resultSet.getString(5);
                double store = resultSet.getDouble(6);
                System.out.println(id + "\t" + name + "\t" + gender + "\t" + age + "\t" + class01 + "\t" + store);
            }
            JDBCDruidUtils.close(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
