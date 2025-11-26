package com.zpy.regext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author zpy
 * 2025/10/26
 */
public class Regexp02 {
    public static void main(String[] args) {
        String s = "张鹏烨教育哈哈哈张鹏烨老师嘿嘿嘿张鹏烨同学噢噢噢噢张鹏烨";
//        Pattern p = Pattern.compile("张鹏烨(?:教育|老师)");
//        Pattern p = Pattern.compile("张鹏烨(?!教育|老师)");
        Pattern p = Pattern.compile("张鹏烨(?=教育|老师)");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println("找到" + m.group(0));
        }
    }
}
