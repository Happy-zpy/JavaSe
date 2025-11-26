package com.zpy.Ordinary;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 作者：张鹏烨
 **/
public class localtime {
    public static void main(String[] args) {
        LocalDateTime i = LocalDateTime.now();
        System.out.println(i);
        System.out.println(i.getYear());
        System.out.println(i.getMonth());
        System.out.println(i.getDayOfMonth());
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");
        System.out.println(d.format(i));
        Instant l = Instant.now();
        System.out.println(l);
        System.out.println(d.format(i.plusDays(777)));

    }
}
