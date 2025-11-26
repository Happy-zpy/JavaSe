package com.zpy.regext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author zpy
 * 2025/10/26
 */
public class regexp03 {
    public static void main(String[] args) {
        String regexp = "(\\d)(\\d)\\2\\1";
        //String s = "1221";
        String s = "11111";
        String regexp02 = "(\\d)\\1{4}";
        System.out.println(Pattern.matches(regexp02, s));

    }
}
