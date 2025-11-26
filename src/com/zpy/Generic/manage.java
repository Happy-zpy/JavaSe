package com.zpy.Generic;
import org.junit.jupiter.api.Test;

/**
 * 作者：张鹏烨
 * 2025/9/5
 **/
public class manage {
    public static void main(String[] args) {
         Dog<Integer,Double> doubleDog = new Dog<>(1,23.3);
         IA ia = new Dog<Integer,Double>(1,1.1);
         ia.fun();
         doubleDog.g();
    }
}
interface IA<T>{
    @Test
    default void fun(){
        System.out.println("哈哈");
    }

}
class Dog<T,I>implements IA<T>{
    T s;
    I y;
    public Dog(T s, I y) {
        this.s = s;
        this.y = y;
    }
    public <e> void g(){

    }

}