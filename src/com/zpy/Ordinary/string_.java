package com.zpy.Ordinary;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 **/
public class string_ {
    public static void main(String[] args) {
        String s = "jjggjjfjjvjnduihbui";
        System.out.println(s.substring(0,5));
        System.out.println(s.indexOf("jj"));
        System.out.println(s.lastIndexOf("jj"));
        String s1 = "hello";
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toUpperCase().toLowerCase());
        String s2 = "暴雨";
        System.out.println(s2.concat("晴天").concat("打雷"));
        String s3 = "aaaaaAAaassssss";
        System.out.println(s3.replace("s","A"));
        String s4 = "pp,ll,kk,oo";
        String[] s5 = s4.split(",");
        System.out.println(s5.length);
        System.out.println(Arrays.toString(s5));
        String s6 = "jsck";//拼接相当于new了一个String;
        String s7 = "kk";
        String s8 = s6 + s7;
        String s9 = "jsckkk";
        System.out.println(s8 == s9);
        System.out.println(s8.intern() == s9);
        String s11 = "hh";
        String s12 = "pp";
        String s13 = "拼接%s,加上%s";
        System.out.println(String.format(s13,s11,s12));


    }
}
