package com.zpy.Reflection.Class;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：张鹏烨
 * 2025/10/8
 **/
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class cls = Class.forName("com.zpy.Reflection.Cat");
        System.out.println(cls);
        System.out.println(cls.getPackage().getName());
        Object o = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getMethod("hi");
        Field name = cls.getField("name");
        System.out.println(name.get(o));
        name.set(o,"ggggg");
        System.out.println(name.get(o));
    }
}
