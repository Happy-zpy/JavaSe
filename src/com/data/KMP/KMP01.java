package com.data.KMP;
/**
 * 作者：张鹏烨
 * 2025/9/18
 **/
public class KMP01 {
    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaaaaaaaaaab";
        String s = "ab";
        int i = M(s1,s);
        System.out.println(i);
    }
    public static int M(String s1,String s2){
        int[] next = fun(s1);
        return K(s1,s2,next);
    }
    public static int[] fun(String s1){
        int[] next = new int[s1.length()];
        next[0] = 0;
        for (int i = 1,j = 0; i < s1.length() ; i++) {
            while (j > 0 && s1.charAt(i) != s1.charAt(j)) {
                j = next[j - 1];
            }
            if (s1.charAt(i) == s1.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public static int K(String s1,String s2,int[] next){
        int j = 0;
        int i = 0;
        while (j < s2.length() && i < s1.length()){
            if (s2.charAt(j) != s1.charAt(i)){
                j = next[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)){
                j++;
                i++;
            }
            if (j == s2.length()) {
                return i - j;
            }
        }
        return -1;
    }
}
