package com.zpy.Thread;

/**
 * 作者：张鹏烨
 * 2025/9/7
 **/
public class thread01 {
    public static void main(String[] args) throws Exception {
        cat cat = new cat();
        dog dog = new dog();
        cat.start();
        dog.start();
//        for (int i = 0; i < 80; i++) {
//            System.out.println("主控制台" + i);
//            Thread.sleep(1000);
//        }
    }
}
class cat extends Thread{
    int sum = 0;
    public void run(){
        while(true){
            System.out.println("猫猫");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sum++;
            if(sum == 8){
                break;
            }
        }
        System.out.println("猫猫先结束");
    }

}
class dog extends Thread {
    int sum = 0;

    public void run() {
        while (true) {
            System.out.println("狗狗");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sum++;
            if (sum == 8) {
                break;
            }
        }
        System.out.println("狗狗先结束");
    }
}