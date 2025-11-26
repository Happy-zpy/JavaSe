package com.zpy.File.IO.Work;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class work01 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\new01.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("没有，已经创建");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\new01.txt"));
        bw.write("hello 张鹏烨");
        bw.close();
    }
}
