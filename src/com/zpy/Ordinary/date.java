package com.zpy.Ordinary;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：张鹏烨
 **/
public class date {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日 kk:mm:ss E");
        System.out.println(s.format(date));
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(s.format(new Date(l)));
        String h = "2025年08月16日 15:48:22 周六";
        try {
            Date j = s.parse(h);
            System.out.println(s.format(j));
        } catch (ParseException e) {
            System.out.println("kk");
        }

    }

}
