package com.zpy.File.IO.InputStream;

import com.zpy.File.IO.OutputStream.Dog;

import java.io.*;

/**
 * 作者：张鹏烨
 * 2025/9/20
 **/
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\experiment\\diary.dat"));
        System.out.println(ois.readInt());
        System.out.println(ois.readUTF());
        System.out.println(ois.readBoolean());
        Dog dog = (Dog) ois.readObject();
        System.out.println(dog);
        System.out.println(dog.getAge());

    }
}
