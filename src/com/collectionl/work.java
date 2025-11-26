package com.collectionl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 作者：张鹏烨
 * 2025/8/19
 **/
public class work {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog(12,"jack"));
        list.add(new Dog(44,"geo"));
        list.add(new Dog(33,"jpp"));
        list.add(new Dog(66,"tom"));
        Iterator iterator = list.iterator();
        while ((iterator.hasNext())){
            System.out.println(iterator.next());
        }
        for (Object o : list) {
            System.out.println(o);

        }


    }
}
class Dog{
    String name;
    int age;
    public Dog(int age,String s) {
        this.age = age;
        this.name = s;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}