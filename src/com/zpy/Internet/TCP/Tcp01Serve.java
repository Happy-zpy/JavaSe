package com.zpy.Internet.TCP;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作者：张鹏烨
 * 2025/9/23
 **/
public class Tcp01Serve {
    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket ser = new ServerSocket(9999);
            System.out.println("等待连接");
            Socket socket = ser.accept();
            byte[] buf = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int read;
            while (( read = inputStream.read(buf)) != -1){
                System.out.println(new String(buf,0,read));
            }
            ser.close();
            inputStream.close();
            socket.close();
        }

    }
}
