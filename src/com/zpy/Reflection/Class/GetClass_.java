package com.zpy.Reflection.Class;

import com.zpy.Reflection.Cat;

/**
 * 作者：张鹏烨
 * 2025/10/8
 **/
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.zpy.Reflection.Cat");
        System.out.println(aClass);
        Class aClass01 = Cat.class;
        System.out.println(aClass01);
        System.out.println(aClass.hashCode());
        System.out.println(aClass01.hashCode());
        Cat cat = new Cat();
        Class aClass02 = cat.getClass();
        System.out.println(aClass02);
        System.out.println(aClass02.hashCode());
        System.out.println(cat.hashCode());
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class cls03 = classLoader.loadClass("com.zpy.Reflection.Cat");
        System.out.println(cls03);
        Class<Integer> integerClass = int.class;
        Class<Integer> type = Integer.TYPE;
        System.out.println(integerClass.hashCode());
        System.out.println(type.hashCode());
    }
}
