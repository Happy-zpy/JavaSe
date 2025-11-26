package com.data.Sorting.Quick;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/16
 **/
public class Quick01 {
    public static void fun(int[] arr,int left,int right){
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int index = (l + r) / 2;
        int median = arr[index];
        int temp;
        while (l < r) {
            while (median > arr[l]) {
                l++;
            }
            while (median < arr[r]) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == median) {
                r--;
            }

            if (arr[r] == median) {
                l++;
            }

        }
        if(l == r){
            l++;
            r--;
        }
            if (left < r) {
                fun(arr, left, r);
            }

            if (right > l) {
                fun(arr, l, right);
            }

    }

    public static void main(String[] args) {
        int[] arr = {8,7,6,54,3,2,-45,67};
        fun(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
