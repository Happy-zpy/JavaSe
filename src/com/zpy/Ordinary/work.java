package com.zpy.Ordinary;

/**
 * 作者：张鹏烨
 **/
public class work {
    public static void main(String[] args) {
       String s = "0123456";
       fun(s,3,6);
       fun(3,6,s);

    }
    public static void fun(String s,int i,int h){
        char[] k = s.toCharArray();
        char temp  ;
        for (int j = 0; j < (h-i)/2; j++) {
           temp = k[i+j];
           k[i+j] = k[h-j];
           k[h-j] = temp;
        }
        System.out.println(k);
    }
    public static void fun(int i,int h,String s){
        char[]k = s.toCharArray();
        char temp;
        for (; i < h; i++,h--) {
            temp = k[i];
            k[i] = k[h];
            k[h] = temp;

        }
        String d = new String(k) ;
        System.out.println(k);
    }
}
