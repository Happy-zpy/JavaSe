package com.zpy.File.IO.Writer;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class OutputSreamWriter_ {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\experiment\\zpy.txt",true), "UTF-8");
        osw.write("zpyssss");
        osw.close();
    }
}
