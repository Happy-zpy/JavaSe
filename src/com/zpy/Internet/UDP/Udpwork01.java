package com.zpy.Internet.UDP;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 作者：张鹏烨
 * 2025/9/25
 **/
public class Udpwork01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        byte[] buf1 = packet.getData();
//        System.setOut(new PrintStream("src\\new01.txt"));
        String s = new String(buf1, 0, packet.getLength());
        switch(s){
            case "四大名著":
                String s1 = "西游水浒红楼三国";
                DatagramPacket packet1 = new DatagramPacket(s1.getBytes("UTF-8"), s1.getBytes("UTF-8").length, InetAddress.getByName("10.55.112.160"),9998);
                socket.send(packet1);
                break;
            default:
                String s2 = "没听明白";
                packet.setData(s2.getBytes("UTF-8"));
                socket.send(packet);
                break;
        }
        System.out.println("已写入指定文件");
        socket.close();
    }
}
