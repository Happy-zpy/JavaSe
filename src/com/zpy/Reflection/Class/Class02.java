package com.zpy.Reflection.Class;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：张鹏烨
 * 2025/10/9
 **/
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.zpy.Reflection.Class.Person");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println();
        Method[] method = aClass.getMethods();
        for (Method method1 : method) {
            System.out.println(method1);
        }
        Method[] declaredMethod = aClass.getDeclaredMethods();
        System.out.println();
        for (Method method1 : declaredMethod) {
            System.out.println(method1);
        }

        System.out.println();

        Constructor<?>[] constructor = aClass.getConstructors();
        for (Constructor<?> constructor1 : constructor) {
            System.out.println(constructor);
        }
        System.out.println();
        Constructor<?>[] declaredConstructor = aClass.getDeclaredConstructors();
        for (Constructor<?> constructor1 : declaredConstructor) {
            System.out.println("本类的所有的构造函数" + constructor1);
        }

        System.out.println("包名" + aClass.getPackage());
        System.out.println("包名" + aClass.getPackageName());
        System.out.println();
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息" + anInterface);
        }
        System.out.println();
        Annotation[] annotation = aClass.getAnnotations();
        for (Annotation annotation1 : annotation) {
            System.out.println("注释信息" + annotation1);
        }

        /*
           public 1 private 2 protected 4 默认 0 static 8 final 16 组合相加
         */

        System.out.println();
        Object object = aClass.getDeclaredConstructor().newInstance();
        for (Field declaredField : declaredFields) {
            System.out.println("属性" + declaredField.getName() + "修饰符的值" + declaredField.getModifiers() + declaredField.get(object));
        }
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);

    }
}

interface B{

}

interface C{

}

class A implements B {
    public String hobby;

    public A() {
    }

    public A(String hobby) {
        this.hobby = hobby;
    }
}
class Person extends A implements B,C{
    public String name = "jj";
    protected int age = 12;
    String height = " 1.8";
    protected double weight = 55.4;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String height) {
        this.height = height;
    }

    private Person(double weight) {
        this.weight = weight;
    }

    public void m1(){

    }

    protected void m2(){

    }

    void m3(){

    }

    private void m4(){

    }

}

