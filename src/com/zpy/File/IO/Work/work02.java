package com.zpy.File.IO.Work;

import java.io.*;
import java.util.LinkedList;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class work02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\experiment\\new02.txt"),"gbk"));
        String line;
        int i = 1;
        while ((line = br.readLine()) != null){
            System.out.print("第" + i + "行: ");
            System.out.println(line);
            i++;
        }
        br.close();
    }
}
