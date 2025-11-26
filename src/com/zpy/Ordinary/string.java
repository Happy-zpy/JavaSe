package com.zpy.Ordinary;

/**
 * 作者：张鹏烨
 **/
public class string {
    public static void main(String[] args) {
        final String[] s = {"zzz","kkk"};
        s[0] = "hhh";//此间表示变量的地址不可变但内容可以变（仅限数组）
        final int[] i = {1,2,3};
        i[0] = 10;
        T t = new T();
        t.change(t.s,t.i);
        System.out.println(t.s);
        char[] o = {1,2,3};
        System.out.println(2+o[0]+o.length);
        String l = "kvhhh";
        System.out.println(l.length());
    }
}
class T{
    String s = "java",name;
    char[] i = {'z','p','y'};
    void change(String s,char[]f){
        s = "kkk";
        f[0] = 'p';
        name = s;
    }


}
