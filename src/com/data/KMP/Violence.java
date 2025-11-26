package com.data.KMP;

/**
 * 作者：张鹏烨
 * 2025/9/18
 **/
public class Violence {
    public static int violence(String s1,String s2){
        if(s1 == null && s1.length() < s2.length()){
            return -1;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < c1.length && j < c2.length){
            if(c1[i] == c2[j]){
                i++;
                j++;
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == c2.length) {
            return i - j; // 返回匹配的起始索引
        } else {
            return -1; // 匹配失败
        }
            }

    public static void main(String[] args) {
        String s1 = "aaaaaaaaa";
        String s2 = "aa";
        System.out.println(violence(s1,s2));
    }
}
