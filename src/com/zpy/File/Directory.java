package com.zpy.File;

import java.io.File;

/**
 * 作者：张鹏烨
 * 2025/9/15
 **/
public class Directory {
    public static void main(String[] args) {
        File file = new File("D:\\experiment");
        if (file.mkdirs()) {
            System.out.println("创建成功");
        }
    }
}
