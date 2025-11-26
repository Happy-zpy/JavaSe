package com.data.Sorting.Bubble;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/12
 **/
public class bubble02 {
    public static void fun(int[] arr){
        boolean flag = false;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!flag){
                break;
            }
            else flag = false;
            System.out.println("第"+(i + 1)+"排序后");
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,6};
        fun(arr);
    }
}
