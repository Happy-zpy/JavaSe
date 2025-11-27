package com.zpy.File.IO.Reader;


import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 作者：张鹏烨
 * 2025/9/17
 **/
public class fileReader {
    @Test
    public void Read(){
        FileReader fileReader;
        String path = "D:\\new02.txt";
        int readen;
        try {
            fileReader = new FileReader(path);
            while ((readen = fileReader.read()) != -1){
                System.out.print((char)readen);
            }
                if(fileReader != null){
                    fileReader.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
@Test
    public void readom(){
        FileReader fileReader;
        String path = "D:\\new02.txt";
        int readen;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(path);
            while ((readen = fileReader.read(buf)) != -1){
                System.out.print((new String(buf,0,readen)));
            }
            if(fileReader != null){
                fileReader.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
