package com.zpy.File.IO.Writer;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/20
 **/
public class BufferedCOPY {
    public static void main(String[] args) throws IOException {
        String srcpath = "D:\\kkp.png";
        String destpsth = "D:\\kk.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcpath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destpsth));
        byte [] buf = new byte[1024];
        int read;
        while ((read = bufferedInputStream.read(buf)) != -1){
            bufferedOutputStream.write(buf,0,read);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
