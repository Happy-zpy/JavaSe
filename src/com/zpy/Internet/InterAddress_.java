package com.zpy.Internet;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 作者：张鹏烨
 * 2025/9/23
 **/
public class InterAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress byName = InetAddress.getByName("10.51.46.67");
        System.out.println(byName);
        InetAddress allByName = InetAddress.getByName("www.baidu.com");
        System.out.println(allByName);
        System.out.println(allByName.getHostAddress());
        System.out.println(allByName.getHostName());
    }
}
