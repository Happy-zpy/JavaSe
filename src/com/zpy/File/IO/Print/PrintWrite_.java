package com.zpy.File.IO.Print;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class PrintWrite_ {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("D:\\experiment\\f2.txt");
        pw.print("jjjjjjjjjjjjjjj");
        pw.close();
    }

}
