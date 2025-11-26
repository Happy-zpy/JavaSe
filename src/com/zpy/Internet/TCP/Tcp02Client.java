package com.zpy.Internet.TCP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 作者：张鹏烨
 * 2025/9/23
 **/
public class Tcp02Client {
    public static void main(String[] args) throws IOException {
        while (true) {
            InetAddress byName = InetAddress.getByName("10.52.222.69");
            Socket socket = new Socket(byName, 9999);
            //Socket socket = new Socket( InetAddress.getByName("10.52.245.87"), 9999);
            System.out.println("连接成功");
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            outputStream.write(s.getBytes());
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            int read;
            byte[] buf = new byte[1024];
            while ((read = inputStream.read(buf)) != -1){
                System.out.println(new String(buf,0,read));
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
