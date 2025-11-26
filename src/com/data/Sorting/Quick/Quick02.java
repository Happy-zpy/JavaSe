package com.data.Sorting.Quick;

import java.util.Arrays;

/**
 * 作者：张鹏烨
 * 2025/9/17
 **/
//切记med一定要用数来表示否则通过下标表示在交换时会改变下标所对应的值导致基准改变从而影响交换的正确性！！！！！！！！！！
public class Quick02 {
    public static void quick(int[] arr ,int left,int right){
        if (left >= right){
            return;
        }
        int l = left;
        int r = right;
        int med = arr[(l + r) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < med) {
                l++;
            }
            while (arr[r] > med) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == med) {
                r--;
            }
            if (arr[r] == med) {
                l++;
            }
        }
            if(l == r){
                l++;
                r--;
            }
            if(r >= left){
                quick(arr,left,r);
            }
            if (right >= l){
                quick(arr,l,right);
            }

    }

    public static void main(String[] args) {
        int[] arr = {8,7,6,54,3,2,-45,67};
        quick(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
