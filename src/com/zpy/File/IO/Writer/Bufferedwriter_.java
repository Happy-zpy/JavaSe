package com.zpy.File.IO.Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 作者：张鹏烨
 * 2025/9/19
 **/
public class Bufferedwriter_ {
    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\new01.txt",true));
        bufferedWriter.write("LLLLLLLLLLLLL");
        bufferedWriter.close();

    }
}
