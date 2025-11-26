package com.zpy.File.IO.OutputStream;
import java.io.FileOutputStream;

/**
 * 作者：张鹏烨
 * 2025/9/16
 **/
public class writeFile {
    public static void fun(){
        String path = "D:\\new01.txt";
        String writer = "hello,world";
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(path,true);
            fileOutputStream.write(writer.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        fun();
    }
}
