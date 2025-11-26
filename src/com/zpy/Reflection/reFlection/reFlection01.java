package com.zpy.Reflection.reFlection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 作者：张鹏烨
 * 2025/10/8
 **/
public class reFlection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/com/re.properties"));
        properties.load(inputStreamReader);
        String name = properties.getProperty("name");
        String method = properties.getProperty("method");
        Class cls = Class.forName(name);
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
        Method method1 = cls.getMethod(method);
        method1.invoke(o);
    }
}
