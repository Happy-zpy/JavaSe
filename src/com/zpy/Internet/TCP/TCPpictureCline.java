package com.zpy.Internet.TCP;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/**
 * 作者：张鹏烨
 * 2025/9/24
 **/
public class TCPpictureCline {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\heart.jpg"));
        byte[] buf = StramUtils.streamToByteArray(bis);
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("连接成功");
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(buf);
        bos.flush();
        socket.close();
        bis.close();
        bos.close();

    }
}
