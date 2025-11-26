package com.data.Sorting.Quick;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/15
 **/
public class Quicksort {
    public static void fun(int [] arr,int left,int right){
        int l = left;
        int r = right;
        int temp;
        int median = arr[(l + r) / 2];
        while(l < r) {
            while (arr[l] < median) {
                l++;
            }
            while (arr[r] > median) {
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
            if (l == r) {
                l++;
                r--;
            }

            if(left < r){
                fun(arr,left,r);
            }
            if(l < right){
                fun(arr,l,right);
            }

    }

    public static void main(String[] args) {
        int[] arr = {8,7,6,54,3,2,-45,67};
        fun(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
