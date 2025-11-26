package com.zpy.Internet.TCP;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * 作者：张鹏烨
 * 2025/9/23
 **/
public class Tcp01Client {
    public static void main(String[] args) throws IOException {
        InetAddress byName = InetAddress.getByName("10.52.222.69");
        Socket socket = new Socket(byName, 9999);
        //Socket socket = new Socket( InetAddress.getByName("10.52.245.87"), 9999);
        System.out.println("连接成功");
        InetAddress.getByName("10.52.245.87");
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        outputStream.write(s.getBytes());
        outputStream.close();
        socket.close();
    }
}
