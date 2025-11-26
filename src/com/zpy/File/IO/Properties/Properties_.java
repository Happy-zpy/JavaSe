package com.zpy.File.IO.Properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class Properties_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("user","apy");
        properties.setProperty("psw","001");
        properties.setProperty("account","aaaaaaa");
        properties.setProperty("code","zxc");
        properties.store(new FileWriter("D:\\workspase\\wrapper\\src\\com\\zpy\\File\\IO\\Properties\\MySql.properties"),null);
        String s = properties.getProperty("user");
        System.out.println(s);

    }
}
