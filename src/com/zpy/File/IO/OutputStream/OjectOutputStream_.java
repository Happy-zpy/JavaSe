package com.zpy.File.IO.OutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 作者：张鹏烨
 * 2025/9/20
 **/
public class OjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\experiment\\diary.dat",true));
        oos.writeInt(1000);
        oos.writeUTF("张鹏烨");
        oos.writeBoolean(true);
        oos.writeObject(new Dog(10,"张志成"));
        oos.close();
    }
}
