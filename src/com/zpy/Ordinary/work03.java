package com.zpy.Ordinary;

/**
 * 作者：张鹏烨
 **/
public class work03 {
    public static void main(String[] args) {
        String s = " 123zxcZXC";
        fun(s);

    }
    public static void fun(String s){
        int i = 0;
        int j = 0;
        int y = 0;
        char [] p = s.toCharArray();
        for (int k = 0; k < p.length; k++) {
            if(Character.isDigit(p[k])){
                i = i + 1;
            }
            if(Character.isLowerCase(p[k])){
                j += 1;
            }
            if(Character.isUpperCase(p[k])) {
                y += 1;
            }

        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(y);

    }

}
