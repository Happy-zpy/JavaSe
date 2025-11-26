package com.zpy.Thread;

import static java.lang.Thread.sleep;

/**
 * 作者：张鹏烨
 * 2025/9/8
 **/
public class thread03 {
    public static void main(String[] args) {
        T01 t01 = new T01();
        t01.start();
        for (int i = 0;i < 20;i++)
        {
            System.out.println("主线程吃东西");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 5){
                try {
                    t01.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
class T01 extends Thread {
    public void run () {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程吃东西");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}