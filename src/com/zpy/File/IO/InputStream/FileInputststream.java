package com.zpy.File.IO.InputStream;

import java.io.FileInputStream;

import java.io.IOException;

/**
 * 作者：张鹏烨
 * 2025/9/15
 **/
public class FileInputststream {
    public static void main(String[] args) {
//        String path = "D:\\new01.txt";
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(path);
//            int read;
//            while(( read = fileInputStream.read()) != -1){
//                System.out.print((char)read );
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        finally {
//            try {
//                fileInputStream.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        fun();
    }
    public static void fun(){
        String path = "D:\\new01.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            byte[] buf = new byte[10];
            while(( fileInputStream.read(buf)) != -1){
                System.out.print(new String(buf) );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
