package com.zpy.File.IO.Writer;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/20
 **/
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String srcFath = "D:\\new02.txt";
        BufferedReader bufferedReader= new BufferedReader(new FileReader(srcFath));
        String dest = "D:\\new04.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
