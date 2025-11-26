package com.zpy.Internet.UDP;

import java.io.IOException;
import java.net.*;

/**
 * 作者：张鹏烨
 * 2025/9/25
 **/
public class UdpreciveA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] buf = "张鹏烨哈哈".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.55.112.160"), 9999);
        socket.send(packet);
        System.out.println("发送成功");
        socket.close();
    }
}
