package com.zpy.Internet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作者：张鹏烨
 * 2025/9/25
 **/
public class Tcpserverwork01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9898);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        String s = "hello";
        bw.write(s);
        bw.newLine();
        bw.flush();
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s1 = br.readLine();
        System.out.println(s1);
        switch (s1){
            case "我是张鹏烨":
                bw.write("你好");
                bw.newLine();
                bw.flush();
                break;
            case "nana":
                bw.write("我不是nana");
                bw.newLine();
                bw.flush();
                break;
            default:
                bw.write("我听不懂");
                bw.newLine();
                bw.flush();
                break;

        }
        System.out.println("结束");
        br.close();
        bw.close();
        serverSocket.close();
        socket.close();

    }
}
