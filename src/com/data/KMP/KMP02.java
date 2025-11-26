package com.data.KMP;

/**
 * 作者：张鹏烨
 * 2025/9/19
 **/
public class KMP02 {
    public static int[] Buildnext(String s){
        int next[] = new int[s.length()];
        int i = 0;
        int j = 1;
        for (; j < s.length(); j++) {
            while (i > 0 && s.charAt(i) != s.charAt(j)){
                i = next[i - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                i++;
            }
            next[j] = i;
        }
        return next;
        }
        public static void K(String s1,String s2){
        int next[] = Buildnext(s2);
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            } else  {
                if(j > 0){
                    j = next[j - 1];
                }
                else j = 0;
            }
            if(j == s2.length()){
                System.out.println("下标为" + (i - j));
            }
        }
        }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaab";
        String s2 = "ab";
        K(s,s2);
    }
    }
