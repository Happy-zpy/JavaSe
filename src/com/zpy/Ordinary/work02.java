package com.zpy.Ordinary;

/**
 * 作者：张鹏烨
 **/
public class work02 {
    public static void main(String[] args) {
        String s = "SSSS WWW II";
        fun(s);
        fun01(s);

    }
    public static void   fun(String s){
        int i = s.indexOf(" ");
        int i1 = s.lastIndexOf(" ");
        String k =  s.substring(i1+1) + ","+ s.substring(0,i) + "." + s.charAt(i + 1);
        System.out.println(k);


    }

public static void fun01(String s){
    String k[] = s.split(" ");
    //String j = k[2] + "," + k[0] + "." + k[1].charAt(0);
    String format = String.format("%s,%s .%c", k[2], k[0], k[1].toUpperCase().charAt(0));
    System.out.println(format);


}}