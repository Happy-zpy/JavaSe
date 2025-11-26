package com.zpy.File.IO.Reader;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 作者：张鹏烨
 * 2025/9/19
 **/
public class BufferedReader_ {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\jj.java"));
        String line;
        while ((line =  bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
    }

}
