package com.zpy.File;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 作者：张鹏烨
 * 2025/9/15
 **/
public class CreateFile {
    @Test

   public void create() {
       File file = new File("D:\\new01.txt");
       try {
           file.createNewFile();
           System.out.println("创建成功");
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
   @Test
    public void create02() {
        File file = new File("D:\\","new02.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
