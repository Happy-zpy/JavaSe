package com.zpy.File.IO.Print;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.println("kkkkkkkkkkkkkkkkkkk");
        out.write("ooooooooooo".getBytes());
        out.close();
        System.setOut(new PrintStream("D:\\experiment\\f1.txt"));
        System.out.println("张鹏烨happy");
    }
}
