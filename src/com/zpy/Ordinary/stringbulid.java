package com.zpy.Ordinary;

/**
 * 作者：张鹏烨
 **/
public class stringbulid {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("888999");
        System.out.println(s);
        s.append("bnffjgj");
        System.out.println(s);
        s.insert(0,"张鹏烨");
        System.out.println(s);
        int i = s.indexOf("8");
        System.out.println(i);
        long time = System.currentTimeMillis();
        System.out.println(time);
        

    }
}
