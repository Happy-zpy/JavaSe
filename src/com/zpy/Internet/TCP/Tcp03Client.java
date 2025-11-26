package com.zpy.Internet.TCP;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 作者：张鹏烨
 * 2025/9/23
 **/
public class Tcp03Client {
    public static void main(String[] args) throws IOException {
        while (true) {
            InetAddress byName = InetAddress.getByName("10.52.222.69");
            Socket socket = new Socket(byName, 9999);
            //Socket socket = new Socket( InetAddress.getByName("10.52.245.87"), 9999);
            System.out.println("连接成功");
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            bw.write(s);
            bw.newLine();
            bw.flush();
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String s1 ;
            while ((s1 = br.readLine()) != null){
                System.out.println(s1);
            }
            bw.close();
            br.close();
            socket.close();
        }
    }
}
