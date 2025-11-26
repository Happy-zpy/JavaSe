package com.zpy.regext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp01 {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("^[0-9a-zA-Z_]+@[0-9a-zA-Z]+(\\.[0-9a-zA-Z])*\\.com$");
        //Pattern compile = Pattern.compile("[0-9]+@[0-9a-zA-Z]+(\\.[0-9a-zA-Z]+){0,}\\.com");
        String Content = "1234urgiuh8999njnjin0987jjiooj3467tt2048991379@qq.com";
        Matcher matcher = compile.matcher(Content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
