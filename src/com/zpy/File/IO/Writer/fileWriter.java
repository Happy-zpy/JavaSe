package com.zpy.File.IO.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 作者：张鹏烨
 * 2025/9/17
 **/
public class fileWriter {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:\\node.txt",true);
            fileWriter.write('H');
            fileWriter.write("张志成XXXXXXXX");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("程序关闭成功");
    }
}
