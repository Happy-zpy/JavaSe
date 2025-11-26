package com.zpy.File.IO.OutputStream;

import java.io.Serializable;

/**
 * 作者：张鹏烨
 * 2025/9/20
 **/
public class Dog implements Serializable {
   private String name;
   private int age;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }
}
