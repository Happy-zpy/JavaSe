package com.zpy.JDBC.ResultSet;

import Utils.JDBCDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@SuppressWarnings({"all"})
public class DbUtils_Use {
    @Test
    public void test(){
        Connection connection = null;
        try {
            connection = JDBCDruidUtils.getConnection();
            String sql = "select * from student";
            QueryRunner queryRunner = new QueryRunner();
            List<student> query = queryRunner.query(connection, sql, new BeanListHandler<>(student.class));
            System.out.println(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCDruidUtils.close(connection,null,null);
        }
    }

    @Test
    public void test1() throws SQLException {
        Connection connection = null;
        connection = JDBCDruidUtils.getConnection();
        String sql = "select * from student where id = 31";
        QueryRunner queryRunner = new QueryRunner();
        student student = queryRunner.query(connection, sql, new BeanHandler<>(student.class));
        System.out.println(student);
    }

    @Test
    public void test2() throws SQLException {
        Connection connection = null;
        connection = JDBCDruidUtils.getConnection();
        String sql = "select name from student where id = 31";
        QueryRunner queryRunner = new QueryRunner();
        Object query = queryRunner.query(connection, sql, new ScalarHandler());
        System.out.println(query);
    }

    @Test
    public void TestDML() throws SQLException {
        Connection connection = null;
        connection = JDBCDruidUtils.getConnection();
        //delete student set name = '张峪' where id = 33
        //String sql = "delete from student where id = 33";
        String sql = " update student set name = '张峪' where id = 31";
        QueryRunner queryRunner = new QueryRunner();
        int update = queryRunner.update(connection, sql);
        //int update = queryRunner.update(connection, sql, "张鹏烨", "男", 18, "高一1班", 88.8);
        System.out.println(update > 0 ? "成功" : "操作失败");
    }
}
