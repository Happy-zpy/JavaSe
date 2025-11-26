package com.data.Sorting.Insert;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/13
 **/
public class insert01 {
    public static void main(String[] args) {
        int[] i = {7,6,5,4,3,21,1};
        fun(i);
        System.out.println(Arrays.toString(i));
    }
    public static void fun(int[] arr){
        int min;
        for (int i = 1; i < arr.length; i++) {
            min = arr[i];
            int index = i -1;
            while(index >= 0 && min < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = min;
        }
    }
}
