package com.zpy.Internet.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 作者：张鹏烨
 * 2025/9/25
 **/
public class TcpClinework01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("10.55.112.160"),9898);
        System.out.println("连接成功");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s1 = br.readLine();
        System.out.println("s1");
        switch (s1){
            case "hello":
                bw.write("我是张鹏烨");
                bw.newLine();
                bw.flush();
                break;
            case "nana":
                bw.write("我不是nana");
                bw.newLine();
                bw.flush();
                break;
            default:bw.write("我听不懂");
                bw.newLine();
                bw.flush();
                break;

        }
        while((s1 = br.readLine()) != null){
            System.out.println(s1);
            System.out.println("接收信号");
        }
        bw.flush();
        bw.close();
        br.close();
        socket.close();

    }
}
