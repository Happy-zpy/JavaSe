package com.zpy.Ordinary;

import java.util.Scanner;

/**
 * 作者：张鹏烨
 **/
public class math {
    public static void main(String[] args) {
        int i = 10100100;
        System.out.println(Math.min(i,2222));
        Math.abs(-9);//绝对值
        Math.pow(3,4);//求幂
        Math.ceil(3.0000001);//向上取整
        Math.floor(3.9999);//向下取整
        Math.round(4.5);//四舍五入
        Math.sqrt(9);//开平方
        //random随机数
        System.out.println((int)(Math.random() * (101)));
        fun();
    }
    public static void fun(){
        int i = (int)(Math.random() * (101));
         Scanner scanner = new Scanner(System.in);
        do {
            int p = scanner.nextInt();
            if(p == i){
                System.out.println("游戏结束");
                break;
            }
            if(p > i){
                System.out.println("大了");
            }
            else{
                System.out.println("小了");
            }
        } while (true);


    }

    }

