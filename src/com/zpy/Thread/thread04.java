package com.zpy.Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 作者：张鹏烨
 * 2025/9/9
 **/
public class thread04 {
    public static void main(String[] args) {
        T02 t = new T02();
        t.start();
        new User(t);
    }
}
class T02 extends Thread {
    static boolean loop = true;
    public void run () {
        while(loop) {
            System.out.println("子线程吃东西");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setLoop(boolean loop) {
        T02.loop = loop;
    }
}
class User extends JFrame implements KeyListener{
    T02 t;

    public User(T02 t) throws HeadlessException {
        this.t = t;
        this.setSize(300,400);
        this.setVisible(true);
        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'q' || e.getKeyChar() == 'Q') {
            T02.setLoop(false); // 修正方法名
            System.out.println("已按下Q键，准备结束子线程");
    }
}
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}