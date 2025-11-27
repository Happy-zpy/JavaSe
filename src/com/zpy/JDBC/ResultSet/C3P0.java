package com.zpy.JDBC.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;


import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0 {
    @Test
    public void test01() throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource c = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        c.setDriverClass(driver);
        c.setJdbcUrl(url);
        c.setUser(user);
        c.setPassword(password);
        c.setInitialPoolSize(5);
        c.setMaxPoolSize(5);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = c.getConnection();
            connection.close();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
