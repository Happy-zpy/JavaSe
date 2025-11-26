package com.zpy.Ordinary;

import java.util.Scanner;

/**
 * 作者：张鹏烨
 **/
public class stringbuffer {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("jack");
        System.out.println(s);
        String s1  = s.toString();
        String s2 = new String(s);
        System.out.println(s.append("我的年龄").append(19));
        System.out.println(s);
        StringBuffer i = new StringBuffer("张鹏烨今年的年龄是20岁");
        System.out.println(i.replace(0,3,"张鑫淼"));//修改数据
        System.out.println(i.insert(0,"张秋雨"));//插入数据
        Scanner scanner = new Scanner(System.in);
        //String o = scanner.next();
        StringBuffer p = new StringBuffer("1111757585383484488787111111.11");
       // System.out.println(fun(p));
        fun(p);
    }
    public static void fun(StringBuffer s){
        int i = s.indexOf(".");
        for(int j = 3; i - j >0 ;j = j + 3){
            System.out.println(s.insert( i -j,","));
        }

    }
}
