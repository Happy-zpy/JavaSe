package com.zpy.Internet.UDP;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 作者：张鹏烨
 * 2025/9/25
 **/
public class Udpwork00
{
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        byte[] buf = s.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.55.112.160"), 9999);
        socket.send(packet);
        System.out.println("发送成功");
        socket.receive(packet);
        int len = packet.getLength();
        buf = packet.getData();
        System.out.println(new String(buf,0,len,"UTF-8"));
        socket.close();
        scanner.close();
    }
}
