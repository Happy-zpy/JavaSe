package WORK;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：张鹏烨
 * 2025/9/7
 **/
public class work01 extends JFrame {
    JTextField textField;
    show p = new show();
    public static void main(String[] args) {
          new work01();
    }

    public work01() throws HeadlessException {
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        p.start();
        textField = new JTextField();
        textField.setText(p.str);
        this.add(textField);
    }
}
class show extends Thread{
    Date date = new Date();
    SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
    String str;
    public void run(){
        while (true){
            str = s.format(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
