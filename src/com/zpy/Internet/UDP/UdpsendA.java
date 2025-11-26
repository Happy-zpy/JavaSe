package com.zpy.Internet.UDP;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 作者：张鹏烨
 * 2025/9/25
 **/
public class UdpsendA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        byte[] buf1 = packet.getData();
        System.setOut(new PrintStream("src\\new01.txt"));
        System.out.println(new String(buf1,0,packet.getLength()));
        System.out.println("已写入指定文件");
        socket.close();
    }
}
