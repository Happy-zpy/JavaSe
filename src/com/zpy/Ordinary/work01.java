package com.zpy.Ordinary;

import java.util.Scanner;

/**
 * 作者：张鹏烨
 **/
public class work01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("账号L:");
        String s = scanner.next();
        System.out.println("密码:");
        String s2 = scanner.next();
        fun(s,s2);

    }
    public static void fun(String s,String h){
        char[] k =h.toCharArray();
        boolean f = true;
        for (int i = 0; i < h.length(); i++) {
            if(!Character.isDigit(k[i])){
                f = false;
                break;

            }
        }
        if(!f){
            System.out.println("密码错误");
        }
        if(s.indexOf("@")-s.indexOf(".") > 0){
            System.out.println("邮箱错误");
        }
        else {
            System.out.println("注册成功");
        }
    }
}


