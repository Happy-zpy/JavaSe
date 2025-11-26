package com.zpy.Ordinary;

import java.util.Calendar;

/**
 * 作者：张鹏烨
 **/
public class calendar {
    public static void main(String[] args) {
       Calendar c =  Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_MONTH) );
        System.out.println(c.get(Calendar.HOUR));//12进制
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));//24进制
        System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
    }
}
