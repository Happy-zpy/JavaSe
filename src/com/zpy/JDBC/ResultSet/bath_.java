package com.zpy.JDBC.ResultSet;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class bath_ {
    public static void main(String[] args) {
        try {
            String sql = "insert into t1 values (null,?)";
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, i + "jack");
                preparedStatement.addBatch();
                if((i + 1) % 1000 == 0){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
            JDBCUtils.close(connection,null,null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
