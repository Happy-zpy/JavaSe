package com.zpy.Internet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作者：张鹏烨
 * 2025/9/24
 **/
public class TCPpictureServe {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");
        InputStream inputStream = socket.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\kk.jpg"));
        byte[] buf = StramUtils.streamToByteArray(inputStream);
        bos.write(buf);
        bos.flush();
//        int read;
//        while((read = inputStream.read(buf)) != -1){
//             bos.write(buf,0,read);
//        }
        bos.close();
        inputStream.close();
        serverSocket.close();
        socket.close();
        System.out.println("创建成功");
    }
}
