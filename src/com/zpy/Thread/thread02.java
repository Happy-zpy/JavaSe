package com.zpy.Thread;

/**
 * 作者：张鹏烨
 * 2025/9/7
 **/
public class thread02 {
    public static void main(String[] args) {
        T t = new T();
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        System.out.println("========");
        for (int i = 0; i < 5; i++) {
            System.out.println("hi" + i);
        }
        for (int j = 0;j < 5;j++ ) {
            t.interrupt();
        }
    }
}
class T extends Thread{
    int sum = 0;
    public void run(){
        while(true){
            for (int i = 0;i < 100;i++)
            {
                System.out.println("实现kk" + i);

            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("子线程在休眠时被中断：" + e.getMessage());
            }
        }
    }

}