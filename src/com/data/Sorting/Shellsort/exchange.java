package com.data.Sorting.Shellsort;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/14
 **/
public class exchange {
    public static void main(String[] args) {
        int[] i = {9, 8, 7, 6, 5, 4, 32, 1, 1};
        fun(i);
        System.out.println(Arrays.toString(i));
    }
    public static void fun(int[] arr){
        int temp;
        for (int gap = arr.length/2; gap > 0 ; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                    else break;
                }
            }
        }
    }
}
