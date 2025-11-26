package com.zpy.Ordinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 作者：张鹏烨
 **/
@SuppressWarnings({"all"})
public class arrays_ {
    public static void main(String[] args) {
        Integer i[] = {65,4,3,22,11};
        System.out.println(Arrays.toString(i));
        Arrays.sort(i);
        System.out.println(Arrays.toString(i));
        Arrays.sort(i,new Comparator(){
            public int compare(Object o1,Object o2){
             int i1 = (int)o1;
             int i2 = (int)o2;
             return i2-i1;
            }
        });
        System.out.println(Arrays.toString(i));
        Arrays.sort(i, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(i));
        //二叉查找，必须有序
        Integer k[] = {1,2,3,4,5,6,7};
        int p = Arrays.binarySearch(k,7);
        System.out.println(p);
        Integer[] o = Arrays.copyOf(k,k.length);
        System.out.println(Arrays.toString(o));
        boolean eqauls = Arrays.equals(o,k);
        System.out.println(eqauls);
        List j = new ArrayList();
        j.add("33");
        boolean b = j.isEmpty();
        System.out.println(j);
        book Book[] = {new book(12,"红楼梦"),new book(11,"三国"),
                new book(99,"Java"),new book(65,"C++")};
        Arrays.sort(Book, new Comparator<book>() {
            @Override
            public int compare(book o1, book o2) {
                return (int)(o1.price - o2.price);
            }
        });
        System.out.println(Arrays.toString(Book));

    }

    }
class book{
    double price;
    String name;
    public book(double d,String s){
        this.name = s;
        this.price = d;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}