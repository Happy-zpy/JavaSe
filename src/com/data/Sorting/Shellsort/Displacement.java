package com.data.Sorting.Shellsort;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/15
 **/
public class Displacement {
    public static void main(String[] args) {
        int[] i = {9, 8, 7, 6, 5, 4, 32, 1, 1};
        fun(i);
        System.out.println(Arrays.toString(i));
    }
    public static void fun(int[] arr){
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while(j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }

            }
        }
    }
}
