package com.collectionl;

import java.util.Objects;

/**
 * 作者：张鹏烨
 * 2025/8/31
 **/
public class work03 {
    public static void main(String[] args) {

    }
}
class kk {
    private int age;
    private String name;

    public kk(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof kk kk)) return false;
        return getAge() == kk.getAge() && Objects.equals(getName(), kk.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }
}