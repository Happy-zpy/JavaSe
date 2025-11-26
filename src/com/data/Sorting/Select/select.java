package com.data.Sorting.Select;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/12
 **/
public class select {
    public static void main(String[] args) {
        int[] i = {6,4,3,2,1};
        fun(i);
        System.out.println(Arrays.toString(i));
    }
    public static void fun(int[] arr){
        if(arr == null){
            System.out.println("数组为空，无法排序");
        }
        for (int i = 0; i < arr.length ; i++) {
            int min = arr[i];
            int indexmin = i;
            for (int j = i + 1; j < arr.length  ; j++) {
                if(min > arr[j]){
                    indexmin = j;
                    min = arr[j];
                }
            }
            if(indexmin != i){
                int temp = arr[i];
                arr[i] = arr[indexmin];
                arr[indexmin] = temp;
            }

        }

    }
}
