package com.data.Search;

/**
 * 作者：张鹏烨
 * 2025/9/19
 **/
public class sedSearch {
    public static int sed(int []arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {222,33,55,66,88,97,33};
        int i = sed(arr,66);
        System.out.println(i);
    }
}
