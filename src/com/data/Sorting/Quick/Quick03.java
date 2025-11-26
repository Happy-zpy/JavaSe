package com.data.Sorting.Quick;

/**
 * 作者：张鹏烨
 * 2025/9/20
 **/
public class Quick03 {
    public static void fun(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int index = (l + r) / 2;
        int med = arr[index];
        int temp;
                while (l < r){
                    while(arr[l] < med){
                        l++;
                    }
                    while (arr[r] > med){
                        r++;
                    }
                    if(l > r){
                        break;
                    }
                    temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    if (arr[l] == med){
                        r--;
                    }
                    if (arr[r] == med){
                        l++;
                    }
                }
                if(l == r){
                    l++;
                    r--;
                }
                if(left < r){
                    fun(arr,left,r);
                }
                if (l < right){
                    fun(arr,l,right);
                }

    }

    public static void main(String[] args) {

    }
}
