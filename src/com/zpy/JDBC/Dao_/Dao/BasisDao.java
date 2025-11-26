package com.zpy.JDBC.Dao_.Dao;

import Utils.JDBCDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasisDao<T>{
    private QueryRunner qr;
    private Connection connection = null;

    public int Update(String sql,T obj,Object... params){
        try {
            Connection connection = JDBCDruidUtils.getConnection();
            return qr.update(connection, sql, obj, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCDruidUtils.close(connection,null,null);
        }
    }

    public List<T> Select(String sql, Class<T> clazz, Object... params){
        try {
            Connection connection = JDBCDruidUtils.getConnection();
            return qr.query(connection,sql,new BeanListHandler<T>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCDruidUtils.close(connection,null,null);
        }
    }

    public T queryHadlen(String sql, Class<T> clazz, Object... params){
        try {
            Connection connection = JDBCDruidUtils.getConnection();
            return qr.query(connection,sql,new BeanHandler<>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCDruidUtils.close(connection,null,null);
        }
    }

    public Object querySalar(String sql,Object... params){
        try {
            Connection connection = JDBCDruidUtils.getConnection();
            return qr.query(connection,sql,new ScalarHandler<>(),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCDruidUtils.close(connection,null,null);
        }
    }

}
