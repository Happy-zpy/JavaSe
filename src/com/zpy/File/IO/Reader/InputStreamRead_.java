package com.zpy.File.IO.Reader;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class InputStreamRead_ {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\experiment\\new04.txt"), "gbk");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        System.out.println(line);
        br.close();
    }
}
