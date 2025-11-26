package com.data.Sorting.Shellsort;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/15
 **/
public class Displacement02 {
    public static void Displacement(int[] arr){
        int temp;
        for (int gap = arr.length / 2; gap > 0 ; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while(j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,66,55,447,889,99,43,21,5,6,};
        Displacement(arr);
        System.out.println(Arrays.toString(arr));
    }
}
