package WORK;

import static java.lang.Thread.sleep;

/**
 * 作者：张鹏烨
 * 2025/9/7
 **/
public class work02 {
    public static void main(String[] args) {
        thread01 thread01 = new thread01();
       //thread01 thread02 = new thread01();
        //thread01 thread03 = new thread01();
        Thread thread = new Thread(thread01);
        Thread thread1 = new Thread(thread01);
        new Thread(thread01).start();
        thread.start();
        thread1.start();


    }

}
class thread01 implements Runnable {
    static int cout = 100;
    public boolean loop = true;
    public  void sell() {
        synchronized (this) {
            if (cout <= 0) {
                System.out.println(Thread.currentThread().getName() + "卖完了");
                loop = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "窗口卖出了一张票，还剩" + --cout + "张票");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void run() {
        while (loop) {
           sell();
    }
   }
}