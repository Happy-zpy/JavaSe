package com.zpy.Internet.TCP;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 作者：张鹏烨
 * 2025/9/23
 **/
public class Tcp03Serve {
    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket ser = new ServerSocket(9999);
            System.out.println("等待连接");
            Socket socket = ser.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String s1;
            while ((s1 = br.readLine()) != null){
                System.out.println(s1);
            }
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write(s);
            bw.newLine();
            bw.flush();
            bw.close();
            ser.close();
            br.close();
            socket.close();
        }

    }
}
