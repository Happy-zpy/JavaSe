package com.zpy.File.IO.OutputStream;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/16
 **/
public class FileCopy {
    public static void main(String[] args) {
        String path = "D:\\jj.java";
        String dest = "D:\\kk.java";
        FileOutputStream fileOutputStream;
        byte[] buf = new byte[1042];
        File file;
        FileInputStream fileInputStream;
        try {
            file = new File(path);
            file.createNewFile();
            fileInputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream(dest);
            int reade;
            while ((reade = fileInputStream.read(buf)) != -1){
                fileOutputStream.write(buf,0,reade);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
