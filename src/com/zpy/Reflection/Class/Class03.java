package com.zpy.Reflection.Class;

import com.zpy.Ordinary.integer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：张鹏烨
 * 2025/10/9
 **/
public class Class03 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.zpy.Reflection.Class.User");
        Object o = aClass.newInstance();
        System.out.println(o);
        Constructor<?> constructor = aClass.getConstructor(int.class);
        Object user = constructor.newInstance(19);
        System.out.println(user);
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);
        Object user02 = declaredConstructor.newInstance(13, "Tom");
        System.out.println(user02);
        System.out.println(user);

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);//使用爆破可以实现反射访问私有属性
        System.out.println(name.get(user));
        Field loop = aClass.getField("loop");//通过这种方式只能获得public的字段
        System.out.println(loop.get(user));
        Field height = aClass.getDeclaredField("height");
        height.setAccessible(true);
        height.set(user,"2222");
        System.out.println(user);
        height.set(null,"7777");//只有静态变量和方法可以传一个null
        System.out.println(height.get(user02));
        System.out.println(user02);
        Method declaredMethod = aClass.getDeclaredMethod("print", int.class, int.class);
        declaredMethod.setAccessible(true);
        Object h = declaredMethod.invoke(user,1,3);//如果有返回值的话创建对象的类型必须是Object
        System.out.println(h);
        Method declaredMethod1 = aClass.getDeclaredMethod("add", String.class);
        declaredMethod1.invoke(user,"张志成是撒比");

    }
}

class User{
    private String name = "jack";
    int age = 12;
    public static boolean loop = false;
    private static String height = "111";

    public User(int age) {
        this.age = age;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User() {
    }

    private static int print(int i ,int h){
        return i + h;
    }

    public void add(String h){
        System.out.println(h);
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' + height +
                '}';
    }

}
