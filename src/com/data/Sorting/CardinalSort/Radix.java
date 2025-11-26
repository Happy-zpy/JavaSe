package com.data.Sorting.CardinalSort;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/18
 **/
public class Radix {
    public static void fun(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        int maxlength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementcount = new int[10];
        for (int i = 0 , n = 1; i < maxlength ;n = n * 10 , i++) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementcount[digitOfElement]] = arr[j];
                bucketElementcount[digitOfElement]++;
            }
            int index = 0;
            for (int j = 0; j < bucketElementcount.length; j++) {
                if(bucketElementcount[j] != 0){
                    for (int k = 0;k < bucketElementcount[j];k++){
                        arr[index++] = bucket[j][k];
                    }
                    bucketElementcount[j] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        fun(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
