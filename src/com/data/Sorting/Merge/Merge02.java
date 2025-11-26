package com.data.Sorting.Merge;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/17
 **/
public class Merge02 {
    public static void merge(int[] arr,int left,int med,int right){
        int i = left;
        int j = med + 1;
        int[] temp = new int[right - left + 1];
        int t = 0;
        while (i <= med && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
            while (i <= med){
                temp[t++] = arr[i++];
            }
            while (j <= right){
                temp[t++] = arr[j++];
            }

        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }
    public static void split(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int med = (left + right) / 2;
        split(arr,left,med);
        split(arr,med + 1,right);
        merge(arr,left,med,right);
    }
    public static void mergesort(int [] arr){
        int left = 0;
        int right = arr.length - 1;
        split(arr,left,right);
    }

    public static void main(String[] args) {
        int[] arr = {8,7,6,54,3,2,-45,67};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
